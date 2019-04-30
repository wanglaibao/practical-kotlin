# Kotlin 1.3: Coroutines
[A first look at Kotlin 1.3: Coroutines no longer experimental] (https://jaxenter.com/first-look-kotlin-1-3-coroutines-147277.html)
[Threads vs Coroutines in Kotlin] (https://www.baeldung.com/kotlin-threads-coroutines)
[Introduction to Kotlin Coroutines] (https://www.baeldung.com/kotlin-coroutines)
[KOTLIN COROUTINES GUIDE – CONCURRENT PROGRAMMING IN KOTLIN] (https://kotlinexpertise.com/kotlin-coroutines-guide/)
[Non-blocking Algorithms 非常重要的系列文档] (http://tutorials.jenkov.com/java-concurrency/non-blocking-algorithms.html)

[kotlin coroutines 协程教程-入门用法] (http://www.pianshen.com/article/7041194670/)

### kotlin coroutine 简介

    Kotlin Coroutine是一个轻量级的线程库，对比java的Executors Framework，主要有以下特点：

* 更轻量级的 api 实现协程

* async 和 await 不作为标准库的一部分

* suspend 函数，也就是挂起函数是比 java future 和 promise 更安全并且更容易使用

协程与线程池区别如下:
* 协程是在用户端对线程进行管理的
* 不同于线程池，协程进一步管理了不同协程切换的上下文，协程间的通信，协程挂起
* 相对于线程挂起来说，协程挂起粒度更小，而且一般不会直接占用到CPU资源
* 所以在编程发展的过程中，广义上可以认为 多进程->多线程->协程。

### 业界对Kotlin的赞美

```
intuitiveness of Kotlin

feature-packed useful standard library

functions as a first-class citizen without scala-like overcomplication

less boilerplate: I can focus on the business logic instead of irrelevant details,
focusing more on “what” instead of “how,”
it’s much more fun (I came originally from non-java langs like Python, Ruby, Scala, and Clojure, so I feel “at home” when programming in Kotlin).

On top of that, I’d like to mention the following specialties of Kotlin that make my life simpler:

bi-directional interoperability with the JVM ecosystem, which allows me to use mature libraries and frameworks

type inference (not only for local variables): this allows you to choose when you want to specify more type details in your code and when you want them to be hidden because they’ll be just noise from reader’s perspective;
immutability is a default modus of operandi: “val” is the default option before you upgrade to “var” only when necessary, “listOf” is the default option before you upgrade to “mutableListOf” only when needed;
rarely used DSLs for very special problems (and for libraries);
combination of named parameters and default argument values is very useful to both reduce duplication and make calls very readable, and let them focus only on what’s important to the reader;
smart-casting after any type check which allows you to not repeat yourself with a direct typecast (or nullable unwrapping): in other typed languages, this is a quite annoying problem, and Kotlin solves it gracefully;
last but not least, while Kotlin is a concise language, it doesn’t go all the way (like Scala or some others), instead, it finds a very good balance where it’s concise enough to let developer maximize the readability of the code, and not stand in the way of doing that. If it was too concise, or not concise enough, it would make it more challenging to write readable code and focus on business logic.
```



### Asynchrony – A programming model

```
    One crucial aspect of asynchronous programming is the fact that asynchronously started actions do not immediately block the program and take place concurrently

    When programming asynchronously, we often find ourselves triggering some subroutine that immediately returns to the caller to let the main program flow continue without waiting for the subroutine’s result.

    Once the result is needed, you may run into two scenarios: 1) the result has been fully processed and can just be requested or 2) You need to block your program until it is available.

    That is how futures or promises work. Another popular example of asynchrony is how reactive streams work like as described in the Reactive Manifesto:

            Reactive Systems rely on asynchronous message-passing to establish a boundary between components that ensures loose coupling, isolation and location transparency.

            […] Non-blocking communication allows recipients to only consume resources while active, leading to less system overhead.


```

### Concurrency – It’s about structure


### Job 的状态分为以下几种情况

*   New (optional initial state) False False False

*   Active(default initial state)	True False False

*   State isActive	isCompleted	isCancelled

*   Completing(transient state) True False False

*   Cancelling(transient state) False False True

*   Cancelled(final state) False True True

*   Completed(final state) False True False



```
那么一个 job 的执行流程如下：

* +-----+ start  +--------+ complete   +-------------+  finish  +-----------+
* | New | -----> | Active | ---------> | Completing  | -------> | Completed |
* +-----+        +--------+            +-------------+          +-----------+
*                  |  cancel / fail       |
*                  |     +----------------+
*                  |     |
*                  V     V
*              +------------+                           finish  +-----------+
*              | Cancelling | --------------------------------> | Cancelled |
*              +------------+                                   +-----------+
```


```
一个job的状态根据执行过程，不断发生变化。
其次，子job和父job相互关联,取消父job会先依次取消子job，
同样子Job取消或者失败也会影响到父Job
```


### launch{} , runBlocking{} ,async{} 源码分析

```
//launch
public fun CoroutineScope.launch(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> Unit
): Job {
    val newContext = newCoroutineContext(context)
    val coroutine = if (start.isLazy)
        LazyStandaloneCoroutine(newContext, block) else
        StandaloneCoroutine(newContext, active = true)
    coroutine.start(start, coroutine, block)
    return coroutine
}


//runBlocking
@Throws(InterruptedException::class)
public fun <T> runBlocking(context: CoroutineContext = EmptyCoroutineContext, block: suspend CoroutineScope.() -> T): T {
    val currentThread = Thread.currentThread()
    val contextInterceptor = context[ContinuationInterceptor]
    val eventLoop: EventLoop?
    val newContext: CoroutineContext
    if (contextInterceptor == null) {
        // create or use private event loop if no dispatcher is specified
        eventLoop = ThreadLocalEventLoop.eventLoop
        newContext = GlobalScope.newCoroutineContext(context + eventLoop)
    } else {
        // See if context's interceptor is an event loop that we shall use (to support TestContext)
        // or take an existing thread-local event loop if present to avoid blocking it (but don't create one)
        eventLoop = (contextInterceptor as? EventLoop)?.takeIf { it.shouldBeProcessedFromContext() }
            ?: ThreadLocalEventLoop.currentOrNull()
        newContext = GlobalScope.newCoroutineContext(context)
    }
    val coroutine = BlockingCoroutine<T>(newContext, currentThread, eventLoop)
    coroutine.start(CoroutineStart.DEFAULT, coroutine, block)
    return coroutine.joinBlocking()
}


//async
public fun <T> CoroutineScope.async(
    context: CoroutineContext = EmptyCoroutineContext,
    start: CoroutineStart = CoroutineStart.DEFAULT,
    block: suspend CoroutineScope.() -> T
): Deferred<T> {
    val newContext = newCoroutineContext(context)
    val coroutine = if (start.isLazy)
        LazyDeferredCoroutine(newContext, block) else
        DeferredCoroutine<T>(newContext, active = true)
    coroutine.start(start, coroutine, block)
    return coroutine
}
```

```
launch{}函数会在当前线程开启一个新的协程，并且不会阻塞当前线程，同时会返回一个 Job 做为 coroutine 的引用，你可以通过这个 Job 取消对应的 Coroutine。

runBlocking{}函数会在开启一个新的协程，并且阻塞当前进程，直到操作完成。这个函数不应该在协程里面使用，它是用来桥接需要阻塞的挂起函数，主要用于 main function 和 junit 测试。也就是说，runBolcking {} 必须用在最上层。

async{}函数会在对应的 CoroutineContext 下创建一个新的协程，并且放回一个Deferred，通过 Deferred 可以异步获取结果，也就是调用Deffered 的 await() 方法。

在 launch 里面会创建一个新的 CoroutineContext，如果没有传入 Context 则使用的 EmptyCoroutineContext,通过 newCoroutineContext() 函数会分配一个默认的 Dispatcher，也就是 Dispatcher.default,默认的全局 Dispatcher，会在jvm 层级共享线程池，会创建等于cpu 内核数目的线程（但是至少创建两个子线程）。接着判断 CoroutineStart 是否 Lazy 模式，如果 Lazy 模式，则该 Coroutine 不会立马执行，需要你主动掉了 Job.start() 之后才会执行。
```



### Java Concurrency vs. Kotlin Coroutines

```
    Many sources describe coroutines as “light-weight threads”;
    they are not a thread as we know them from, e.g., Java though.
    Compared to threads, coroutines are mostly very cheap in their creation,
    and the overhead that naturally comes with threads isn’t around.
    One reason is that they’re not directly mapped to native threads.
    As we will see, coroutines are executed in thread pools that are mainly managed by the library.
    Another critical difference is “limitation”:
    Threads are very limited because they rely on available native threads,
    coroutines on the other side are almost free,
    and thousands can be started at once (although this depends on what they compute).
 ```


### How to use Coroutines

```
    1: Coroutines are based on a new type of functions called suspending functions.
        We can mark methods with a new language keyword called suspend.
        A function marked with this keyword can suspend a coroutine execution,
        but is not blocking the thread.

        suspend fun fetchUserData(userId: String): String {
            // return user String
        }

    2:  A suspending function can only be called from coroutines or other suspending functions.
        Usually we will meet them in forms of lambda parameters on the coroutine library functions, like async:

        public fun <T> async( … , … , block: suspend CoroutineScope.() -> T): Deferred<T> {
        …
        }

    3:  launch{}

        The launch function is the simplest tool to use coroutines, if you don't care about return values.

        val job = launch {
          val userString = fetchUserString("1")
          val user = deserializeUser(userString)
          log(user.name)
        }

        The wrapped code is dispathced to a background thread, and the function itself returns a Job instance,
        which can be used in other coroutines to control the execution.
        Calling the join() method on the Job will supspend the computation of its containing coroutine.

    4: async{}

       With using the async function you can achieve the same behaviour as with launch, with one important difference: it can return a value.

        val user = async {
          val userString = fetchUserString("1")
          val user = deserializeUser(userString)
          user
        }.await()

       The async function returns a Defered<T> instance, and calling await() on it you can get the actual result of the computation.

```

### Threads vs Coroutines

```
    Spawning a thread costs a lot of resources.
    On a modern system, one thread can easily eat up almost a megabyte of memory.

    Usually, a coroutine is sitting on an actual thread pool,
    which is used for background execution, and that's why it so effective.


```




### What's inside async{}

```
    Let's take a look how the signature of the async{} function looks like!


    public fun <T> async(
      context: CoroutineContext = DefaultDispatcher,
      start: CoroutineStart = CoroutineStart.DEFAULT,
      block: suspend CoroutineScope.() -> T
    ): Deferred<T>


    The first parameter is a CoroutineContext, which defines the threads where the execution will take place.
    It has a default value, which eventually points to a predefined thread pool.
    But this can be replaced with any other implementation.


    The start parameter is to specify the behavior for when a coroutine should start.
    By default, when the execution reaches a line with an async{} or a launch{} function, work inside of the coroutine is started.

    With using the CoroutineStart.LAZY value, a coroutine will only start if the developer explicitly calls await() or join() on the returned Deferred<T> or Job instance.

```


### The magical state machine 【状态机魔法】

```
    The internal coroutine implementation involves the dark arts of some serious compiler magic. With some simplification, here is what's happening:


    Every suspending function and lambda has a hidden parameter which is implicitly passed to it when it's invoked.
    This parameter is a Continuation instance which symbolizes a block of code which should be executed after a coroutine suspension.

    Let's see the await function which looks like this:

    suspend fun <T> Deferred<T>.await(): T

    However, actually it's more like this:

    fun <T> Deferred<T>.await(continuation: Continuation<T>): Any?

    The result type T of the await is now in the continuation parameter.
    The Any at the end of the signature is used for the control flow of the coroutine.
    If it is suspended, the result of the await will be a special COROUTINE_SUSPENDED value.
    If it's not, it returns the T result of the function.


    For each coroutine lambda, a new class is created at compile time.
    This class is basically a state machine.
    The compiler analyzes the code and looks for suspending functions - these points will be the states of the state machine (because that's where the execution can be suspended).

    As per our example:

    launch(UI){
      val userString = fetchUserString("1").await() // suspension point #1
      val user = deserializeUser(userString).await() // suspension point #2
      showUserData(user)
    }


    In this generated class, the execution jumps from one state to another while the thread where the code is running is not blocked.
    After a suspending function finished, and the result is available,
    its Continuation parameter can trigger the state machine to jump to the next state.

```


### Exception handling

```
    Exception handling is as usual.
    Imagine the above-described state machine nested into a huge try/catch block!
    If something throws an exception, it will be caught and propagated, meaning you don't have to change anything.
    Business as usual.


    launch(UI) {
      progressBar.visibility = View.VISIBLE
      try {
        val userString = fetchUserString("1").await()
        val user = deserializeUser(userString).await()
        showUserData(user)
      } catch (ex: Exception) {
        log(ex)
      } finally {
        progressBar.visibility = View.GONE
      }
    }

```


### Cancellation

```
    Cancelling a coroutine is posible, and fairly similar to how you can cancel threads:

    val job = launch {
      // do work
    }
    job.cancel()


    Calling the cancel() function on a Job or on a Deferred<T> instance will stop the inner computation on a coroutine if the handling of the isActive flag is properly implemented.

    val job = launch {
      while (isActive){
        //do work
      }
    }


    Also, isActive is checked between child coroutine suspension points by the standard library,
    so you only have to check isActive in your own long-running computations.


```
