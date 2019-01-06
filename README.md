#           practical-kotlin
## 打包命令  mvn clean package -Dmaven.test.skip=true

[tutorialkart] (https://www.tutorialkart.com/kotlin-tutorial/)

[Kotlin Tutorial With Example For Beginner] (https://tutorialwing.com/kotlin-tutorial-example-beginner/)

[Learn Kotlin - Tutorial for Beginners] (https://www.programiz.com/kotlin-programming)

[Kotlin Examples] (https://www.programiz.com/kotlin-programming/examples)

[Kotlin Tutorial] (https://grokonez.com/kotlin-tutorial)




整数类型添加?后缀与不加?后缀还有一个区别:
普通类型的整型变量将会映射成Java的基本类型带?后缀的整型变量将会映射成基本类型的包装类.
eg:
Kotlin程序中Int类型的变量将会映射成Java的int基本类型,但Int?类型的变量则会自动映射成Java的Integer类型.

Kotlin的整数数值有3种表示方式:

1：十进制：最普通的整数数值就是十进制的整数。

2：二进制：以Ob或OB开头的整数数值就是二进制的整数。

3：十六进制：以0x或0X开头的整数数值就是十六进制的整数,其中10到15分别以a到f(此处的a到f不区分大小写)来表示。

备注：Kotlin不支持八进制的整数

备注：Kotlin虽然不允许直接将Char型值当成整数值使用，也不允许将整数值直接当成Char型值使用，但Kotlin依然可调用数值型的toChar方法将数值型变量或表达式转换为Char类型。



要指出的是,只有可空类型的变量或常量才能接受null,非空类型的变量或常量不能接受null。


Kotlin对可空类型进行了限制：如果不加任何处理，可空类型不允许直接调用方法、访问属性。
因此，通过可空类型与非空类型的区分，KotIin即可在程序中避免空指针异常。


可空类型的变量不允许直接调用方法或属性，但可以先判断该变量不为null，然后再调用该变量的方法或属性。


对于可空的Boolean类型而言,它可以接受3个值,即true,false或null,因此对Boolean?类型变量进行判断时,需要使用Boolean?变量显式与true,false值进行比较。


单目前缀运算符有＋、－、！这三个
+  ===  unaryPlus()
-  ===  unaryMinus()
!  ===  not()

自增和自减运算符
++    <=====>   inc()
--    <====>  dec()


双目算术运算符
+      <====>      plus()
-      <====>      minus()
*      <====>      times()
/      <====>      div()
%      <====>      rem()
..     <====>      rangeTo()