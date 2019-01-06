#   KOTLIN 极客时间专题
## 1: 基础语法
   var name1: String = "asfasf"
   var names2:String? = null;
   // 下面这种赋值语法是错误的，可空类型不可以赋值给非空类型
   name1 = name2
   
   // 下面这种赋值语法是正确的，可空类型通过强制转换为非空类型可以赋值
   name1 = name2!!
   
   // 下面这种赋值语法是正确的，非空类型可以赋值给可空类型
   name2 = name1


## 2：与Java的相互调用

   语法变化【Java与Kotlin交互的语法变化】
        // Utils.kt
         fun echo(name:String):Unit {
                println("$name")
         }
        
        // Main.java
        public static void main(String[] args) {
                UtilsKt.echo("hello")
        }
        
        
        
        object Test {
             fun sayMessage(msg:String):Unit {
                    println(msg)
             }
        }
        
        // kotlin code:   Test.sayMessage("jinge")
        
        //Java code:   Test.INSTANCE.sayMessage("jinge")
        
   
   
        //java code: TestMain.class    [TestMain.java]
        //kotlin code: TestMain::class.java
   
   
   
   
   
   Kotlin关键字处理
   
   
   
   基本数据类型的处理


































