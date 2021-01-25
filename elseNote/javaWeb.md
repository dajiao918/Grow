---

---

#                                         JavaWeb



[TOC]



## jQuery入门
``` javaScript
* jQuery必须引入jQuery类库
* $是一个函数
* $("#ID"),表示利用id获取标签对象
* $(function(){}) 等价于 window.onload = function(){}文档加载完之后执行这个函数
* $(HTML字符串时)：根据这个字符创建元素节点对象
* $(选择器字符串时)：根据这个字符查找元素节点对象
* $(DOM对象时)：返回一个jQuery对象
```

``` javascript
### jQuery对象的本质
* 是dom对象数组，并且提供了一系列的函数
* jQuery对象不能使用dom对象的方法，同理dom对象也不能使用jquery对象的方法
* $(dom对象) ===>>将dom对象转换为jQuery对象
* $(dom对象)【下标值】将jQuery对象转换为dom对象

$(function(){
			testDiv.css("color","red")
			testDiv.style.color = "blue";
			 let arr = [123,true,"saa"];

			//jQuery对象的本质：对象数组+jQuery提供的一系列函数
			//jQuery获取标签对象集合，相当于DOM对象数组
			let $button = $("button");
			for(let i=0; i<$button.length; i++){
			 	alert($button[i]);
			}

			//证明jQuery不能使用dom对象的方法，同理，dom对象也不能使用jQuery的方法
			// document.getElementById("testDiv").innerHTML = "dom对象修改内容";
			// $("#testDiv").innerHTML = "jQuery修改内容";
			//dom对象转换为jQuery对象，直接用$(dom对象)包装即可
			alert( $(document.getElementById("testDiv"))	 );
			//jQuery对象转换为dom对象，用jQuery对象【下标】即可
			alert( $(document.getElementById("testDiv"))[0] );
		});

```

### 基本选择器

``` javascript
* $("#ID").css(设置id为ID的css样式)
* $(".class")选择class的标签对象
* $("标签名")选择对应标签名的对象
* $("*")选择所有元素
* $("标签名，#id，.class"),选择对应标签名，id，class的对象
  $(function(){//表示window.onload加载页面事件
  			//1.选择 id 为 one 的元素 "background-color","#bbffaa"
  			$("#btn1").click(function (){
  				$("#one").css("background-color","#bbffaa");
  			})
  			//2.选择 class 为 mini 的所有元素
  			$("#btn2").click(function(){
  				$(".mini").css("background-color","#bbffaa");
  			});
  			//3.选择 元素名是 div 的所有元素
  			$("#btn3").click(function(){
  				$("div").css("background-color","#bbffaa");
  			});
  			//4.选择所有的元素
  			$("#btn4").click(function(){
  				$("*").css("background-color","#bbffaa");
  			})
  			//5.选择所有的 span 元素和id为two的元素
  			$("#btn5").click(function(){
  				$("span,#two").css("background-color","#bbffaa");
  			});
  		});
```

### 层次选择器

``` javascript
* $("body div")选择body里面所有的div标签
* $("body > div")选择body里面所有的子代div标签
* $("#one + div")选择ID为one的下一个div标签
* $("#two ~ div")选择ID为two后面的所有兄弟div标签
  $(document).ready(function(){ //$(function(){})的全写
  			//1.选择 body 内的所有 div 元素
  			//$("body div"),表示body标签里面的所有div标签对象
  			$("#btn1").click(function(){
  				$("body div").css("background", "#bbffaa");
  			});
  			//2.在 body 内, 选择div子元素
  			//$("body > div"),选中body的子标签对象
  			$("#btn2").click(function(){
  				$("body > div").css("background", "#bbffaa");
  			});
  			//3.选择 id 为 one 的下一个 div 元素
  			//$("#one + div"),选中id 为 one 的下一个 div 元素
  			$("#btn3").click(function(){
  				$("#one + div").css("background", "#bbffaa");
  			});
  			//4.选择 id 为 two 的元素后面的所有 div 兄弟元素
  			//$("#id ~ div")
  			$("#btn4").click(function(){
  				$("#two ~ div").css("background", "#bbffaa");
  			});
  		});
```



### 基本过滤选择器

``` javascript
* $("div:first")选择第一个div元素
* $("div:last")选择最后一个div元素
* $("div:not(.one)")选择class不为one的所有div元素
* $("div:not(#two)")选择ID不为two的所有div元素
* $("div:even")选择所有下标为偶数的div元素，从零开始计数，偶数包括0
* $("div:odd")选择所有下标为奇数的div元素
* $("div:gt(3)")选择所有下标大于3的div元素
* $("div:lt(3)")选择所有下标小于3的div元素
* $("div:eq(3)")选择小标等于3的div元素
* $(":header")选择所有的主题标签元素
* $(":animated")选择所有正在执行动画的标签元素
  //1.选择第一个 div 元素  
  			$("#btn1").click(function(){
  				$("div:first").css("background", "#bbffaa");
  			});
  			//2.选择最后一个 div 元素
  			$("#btn2").click(function(){
  				$("div:last").css("background", "#bbffaa");
  			});
  			//3.选择class不为 one 的所有 div 元素
  			$("#btn3").click(function(){
  				$("div:not(.one)").css("background", "#bbffaa");
  			});
  			//4.选择索引值为偶数的 div 元素
  			$("#btn4").click(function(){
  				$("div:even").css("background", "#bbffaa");
  			});
  			//5.选择索引值为奇数的 div 元素
  			$("#btn5").click(function(){
  				$("div:odd").css("background", "#bbffaa");
  			});
  			//6.选择索引值为大于 3 的 div 元素
  			$("#btn6").click(function(){
  				$("div:gt(3)").css("background", "#bbffaa");
  			});
  			//7.选择索引值为等于 3 的 div 元素
  			$("#btn7").click(function(){
  				$("div:eq(3)").css("background", "#bbffaa");
  			});
  			//8.选择索引值为小于 3 的 div 元素
  			$("#btn8").click(function(){
  				$("div:lt(3)").css("background", "#bbffaa");
  			});
  			//9.选择所有的标题元素
  			$("#btn9").click(function(){
  				$(":header").css("background", "#bbffaa");
  			});
  			//10.选择当前正在执行动画的所有元素
  			$("#btn10").click(function(){
  				$(":animated").css("background", "#bbffaa");
  			});
  		});
```



### 内容选择器

``` javascript
* $("div:contains('di')")选择文本包含di的div元素
* $("div:empty")选择文本为空且没有子元素的div标签
* $("div:has(.mini)")选择包含class为mini的元素div元素
* $("div:parent")选择有文本内容或者是有子元素的div标签
  $(document).ready(function(){
  			//1.选择 含有文本 'di' 的 div 元素
  			$("#btn1").click(function(){
  				$("div:contains(di)").css("background", "#bbffaa");
  			});
  			//2.选择不包含子元素(或者文本元素) 的 div 空元素
  			$("#btn2").click(function(){
  				$("div:empty").css("background", "#bbffaa");
  			});
  			//3.选择含有 class 为 mini 元素的 div 元素
  			$("#btn3").click(function(){
  				$("div:has(.mini)").css("background", "#bbffaa");
  			});
  			//4.选择含有子元素(或者文本元素)的div元素
  			$("#btn4").click(function(){
  				$("div:parent").css("background", "#bbffaa");
  			});
  		});
```



### 复合选择器

``` javascript
* $("div[title]")选择含有属性title的div标签
* $("div[title=test]")选择属性titile等于test的div标签
* $("div[title^=te]")选择属性title以te开头的div标签
* $("div[title$=st]")选择属性title以st结尾的div标签
* $("div[title*=es]")选择属性title中含有es的div标签
* $("div[title!=test]")选择属性titile不等于test的div标签
* $("div[title][title!=test]")选择含有属性值title但值不等于test的div标签
* $("div[id][title*=es]")选择含有id属性且title中含有es的div标签
  $(function() {
  	//1.选取含有 属性title 的div元素
  	$("#btn1").click(function() {
  		$("div[title]").css("background", "#bbffaa");
  	});
  	//2.选取 属性title值等于'test'的div元素
  	$("#btn2").click(function() {
  		$("div[title='test']").css("background", "#bbffaa");
  	});
  	//3.选取 属性title值不等于'test'的div元素(*没有属性title的也将被选中)
  	$("#btn3").click(function() {
  		$("div[title!='test']").css("background", "#bbffaa");
  	});
  	//4.选取 属性title值 以'te'开始 的div元素
  	$("#btn4").click(function() {
  		$("div[title^='te']").css("background", "#bbffaa");
  	});
  	//5.选取 属性title值 以'est'结束 的div元素
  	$("#btn5").click(function() {
  		$("div[title$='est']").css("background", "#bbffaa");
  	});
  	//6.选取 属性title值 含有'es'的div元素
  	$("#btn6").click(function() {
  		$("div[title*='es']").css("background", "#bbffaa");
  	});
  	//7.首先选取有属性id的div元素，然后在结果中 选取属性title值 含有'es'的 div 元素
  	$("#btn7").click(function() {
  		$("div[id][title*='es']").css("background", "#bbffaa");
  	});
  	//8.选取 含有 title 属性值, 且title 属性值不等于 test 的 div 元素
  	$("#btn8").click(function() {
  		$("div[title][title!='test']").css("background", "#bbffaa");
  	});
  });
```

### 表单过滤选择器

``` javascript
* $(":input")选中所有的input标签
* $(":text")选中所有的type=text的input标签
* $(":checkbox")选中所有的的多选框标签
* $(":checkbox:checked")选中所有的已经被选中的多选框标签
* $("select option:selected")选中select标签下的子标签option，再在结果中选择被选中的option标签
* jQuery新增了遍历方法：$标签变量名.each(function(){alert（this.value）})，this是当前遍历到的dom对象
//1.对表单内 可用input 赋值操作
				$("#btn1").click(function(){
					//val可以进行赋值和取值
					$(":text:enabled").val("赋值。。。");
				});
				//2.对表单内 不可用input 赋值操作
				$("#btn2").click(function(){
					$(":text:disabled").val("不可用赋值");
				});
				//3.获取多选框选中的个数  使用size()方法获取选取到的元素集合的元素个数
				$("#btn3").click(function(){
					alert( $(":checkbox:checked").size() );
				});
				//4.获取多选框，每个选中的value值
				$("#btn4").click(function(){
					let $checkbox = $(":checkbox:checked");
					//老式遍历方法
					// for(let i=0; i<$checkbox.size(); i++){
					// 	alert( $checkbox.val() );
					// }

					//jQuery提供了新的遍历方法
					//each(function(){内容}),可以获取this对象，就是当前遍历到的dom对象
					$checkbox.each(function (){
						alert( this.value );
					});

				});
				//5.获取下拉框选中的内容  
				$("#btn5").click(function(){
					let $selection = $("select option:selected");
					// for(let i=0; i<$selection.size(); i++){
					// 	alert( $selection.val() );
					// }
					$selection.each(function (){
						alert( this.value );
					});
				});
			})	
```

### 元素筛选方法

``` javascript
* $("div").eq(3)  选择索引值为等于 3 的 div 元素
* $("div").first()  选择第一个 div 元素
* $("div").last() 选择最后一个div元素
* $("div").filter(":even")  在div中选择索引为偶数的
* $("#one").is(":empty")  判断#one是否为:empty
* $("div").has(".mini")  选择div中包含.mini的
* $("div").not(".one")  选择div中class不为one的
* $("body").children("div.one")  在body中选择所有class为one的div子元素
* $("body").find("div.mini")在body中选择所有class为mini的div元素，是查找正在处理的元素的好方法
* $("#one").next("div")  #one的下一个div
* $("#one").nextAll("span")  #one后面所有的span元素
* $("#one").nextUntil("span") 	#one和span之间的元素
* $(".mini").parent() class为.mini的父元素
* $("#two").prev()  #two的上一个div
* $("span").prevAll("div")  span前面所有的div
* $("span").prevAll("#one")  span向前直到#one的元素
* $("two").siblings()  #two的所有兄弟元素
* $("span").add("#one") 选择器所有的span元素和id为one的元素
```

### 五种方法(html,text,val，arrt，prop)

``` javascript
html():
$("div").html("<hi>标题1</h1>，文本")，可以设置文本和标签
text()：
$("div").text("<h1>我全是文本，不能生成标题1</h1>")
val():
$(":radio").val(["value"])，可以设置选中状态
$(":checkbox").val(["value1","value2",...])可以同时设置多个选中状态
$("select").val(["value"])设置选中状态
$(":checkbox:first").attr("name")获取name属性的值
$(":checkbox:first").attr("name","checkbox1")设置name属性的值
alert( $(":checkbox").attr("checked") ),会弹出undefined，或者是checked
alert( $(":checkbox").prop("checked") ),此时会弹出true或者是false
attr()不推荐操作checked，readOnly，selected，disabled，还可以对自定义的属性进行操作
prop()只推荐操作checked，readOnly，selected，disabled
$(":radio,:checkbox,:select").val(["radio1","checkbox1","checkbox2","select1"])可以一次只能够写完所有需要被选中的框框
	$(funtion(){
            alert( $("div").html() );
            $("div").html("<h1>我可以设置标签</h1>")
            $("div").text("<h1>我就是值能设置文本</h1>")
            $(":radio").val(["rao1"]);
            $(":radio").val(["rao2"]);
            $(":checkbox").val(["checkbox1","checkbox2","checkbox3"]);
            $("#multi").val(["mutl1","mutl2"]);
            $("select").val(["select2"])
	});
```

### dom对象的增删改查

``` javascript
* a.appendTo(b),将a插入到b子元素的末位
* a.prependTo(b)，将a插入到b子元素的第一位
* a.insertAfter(b),将a标签插在b标签的后面一位
* a.insertBefore(B),将a标签插在b标签的前面一位
* a.replace(b),将a替换成b
* b.replaceAll(b),将a全部替换为b
* a.remove(),删除a标签
* a.empty(),清除a标签里面的内容
<script type="text/javascript" src="../script/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        //html方法可以设置内容也可以获取
        $(function(){
            $("<h1>标题1</h1>").appendTo("div");
            $("<h1>标题1</h1>").prependTo("div");
            $("<h1>标题1</h1>").insertBefore("div");
            $("<h1>标题1</h1>").insertAfter("div");
            $("div").replaceWith("<h1>标题1</h1>");
            $("div").replaceAll("<h1>标题1</h1>");
            $("div").remove();
            $("div").empty();
        })
    </script>
<body>
    <div>我是div标签<span>我是div里面的span标签</span></div>
    <div>第二个div</div>
</body>
```

### 添加css样式

``` javascript
* addClass(),可以用标签对象.addClass("样式1，样式二")来添加样式
* removeClass(),可以用标签对象.removeClass()删除全部样式，标签对象.removeClass("样式1")删除特定样式
* toggleClass(),可以用标签对象.toggleClass("样式一")删除或者添加样式，若标签对象已有样式一，删除，反之添加。
* offset(),可以用标签对象.offset({top:xx  left:xx})top表示距离浏览器顶部的距离，left表示距离浏览器左边的距离，对标签元素进行位置设置
<style>
    div.redDiv{
		background-color: red;
	}
	
	div.blueBorder{
		border: 5px blue solid;
	}
</style>
<Script type="text/javaScript">
    $(function(){
            var $divEle = $('div:first');
            $('#btn01').click(function(){
                //addClass() - 向被选元素添加一个或多个类
                $divEle.addClass("blueBorder");
            });
            $('#btn02').click(function(){
                //removeClass() - 从被选元素删除一个或多个类 ,不添加内容就是删除全部
                // $divEle.removeClass();
                $divEle.removeClass("redDiv");
            });
            $('#btn03').click(function(){
                //toggleClass() - 对被选元素进行添加/删除类的切换操作
                //有redDiv样式就是删除，没有就是添加
                $divEle.toggleClass("redDiv");
            });
            $('#btn04').click(function(){
                //offset() - 返回第一个匹配元素相对于文档的位置。
                $divEle.offset({
                    top:100,
                    left:50
                });
                // console.log(offset);

            });
        })
</script>
```

### 动画操作

``` javascript
* $('div').show(1000,function(){set}),显示隐藏的div元素
* $('div').hide(1000,function(){set}),隐藏显示的div元素
* $('div').toggle(1000,function(){set}),切换（显示/隐藏）
* $('div').fadeIn(1000,function(){set}),淡入隐藏的元素
* $('div').fadeOut(1000,function(){set}),淡出显示的div元素
* $('div').fadeToggle(1000,function(){set}),切换淡出/淡入操作
* $('div').fadeTo(1000,0.5,function(){set}),将动画淡化到谋个程度，0.5是半透明，0是完全透明，1是完全显示
*** 设置动画的不停止切换
1.
	let contionueFun = function(){
    	$('div').toggle(1000,contionueFun);
	}
2.
    let continueFun = function(){
        $('div').fadeToggle(1000,continueFun);
    }
exe:
	$(function(){
			//显示   show()
			$("#btn1").click(function(){
				$("div").show(1500,function (){
					alert("show犯法完成");
				});
			});		
			//隐藏  hide()
			$("#btn2").click(function(){
				$("div").hide(1500,function (){
					alert("hide事件完成");
				});
			});	
			//切换   toggle()
			$("#btn3").click(function(){
				$("div").toggle(1000,function (){
					alert("toggle事件完成！");
				});
			});	
			// let continueFun = function (){
			// 	$('div').toggle(1000,continueFun);
			// }
			// continueFun();
			//淡入   fadeIn()
			$("#btn4").click(function(){
				$("div").fadeIn(1000,function (){
					alert('fade事件完成');
				});
			});	
			//淡出  fadeOut()
			$("#btn5").click(function(){
				$("div").fadeOut(1000,function (){
					alert('fadeout事件完成！');
				});
			});	
			
			//淡化到  fadeTo()
			$("#btn6").click(function(){
				$('div').fadeTo(1000,0.5,function (){
					alert('淡化事件完成！');
				});
			});	
			//淡化切换  fadeToggle()
			$("#btn7").click(function(){
				$('div').fadeToggle(1000,function (){
					alert('淡化切换事件完成');
				});
			});
			let continueFun = function (){
				$('div').fadeToggle(1000,continueFun);
			}
			continueFun();
		})
```

### jQuery事件操作

``` javascript
* 触发的顺序
	jQuery页面加载完之后先触发，js的页面加载后后触发。
* 什么时候触发
	jQuery的页面加载完成之后是在浏览器解析完标签创建号dom对象之后就会马上执行
    js的页面加载完成之后在浏览器解析完标签创建号dom对象，还要等标签显示时需要的内容加载完成
* 他们执行的次数
	jQuery页面加载完成时是把注册的$(function(){})依次执行
    js页面加载完成只会执行最后一个window.onload = function(){},前面的都会被覆盖掉
```

### jQuery处理事件的其他方法

``` javascript
* bind(),可以绑定一个或者多个事件，并且事件可以多次执行
* unbind(),接触绑定
* mouseover()，鼠标移入事件
* mouseout(),鼠标移出事件
* one(),可以绑定一个或者多个事件，但每个事件只能执行一次
* live(),可以绑定一个或者多个事件，并且事件可以多次执行，哪怕元素是动态创建的元素
				bind
				$('h5').bind("click mouseover mouseout",function (){
					console.log("bind绑定的额多个事件");
				});
				//unbind
				$('h5').unbind("click");
				one
				$('h5').one("click mouseover mouseout", function (){
					console.log("one的绑定事件");
				});

				live
				$('<h5 class="head">什么是jQuery?</h5>').appendTo("#panel");
				$('h5').live("click mouseover", function (){
					console.log("live的绑定事件");
				})
```

### jQuery的冒泡和事件对象

``` javascript
* 事件冒泡：当父元素和子元素同时监听一件事情是，子元素响应之后还会传给父元素，称为事件的冒泡
 	 <script type="text/javascript">
			$(function() {
				$("#content").click(function (){
					alert("div父元素")
				});

				$("span").click(function (){
					alert("span子元素");
					return false;
				});
			})
	</script>
	<div id="content">
			外层div元素
			<span>内层span元素</span>
			外层div元素
	</div>
* 事件对象
 原生JavaScript获取事件对象
 	window.onload = function(){
        document.getElementById("areaDiv").onclick = function(event){
            //打印事件对象
            console.log(event)
        }
    }
 jQuery获取事件对象
 	$(function(){
        $("#areaDiv").click(function(event){
            //打印事件对象
            console.log(event);
        })
    })
 事件对象的应用
 $(function(){
     $("#areaDiv").bind("mouseover mouseout",function(event){
         if(event.type == 'mouseover'){
             console.log("鼠标移入事件");
         } else (event.type == 'mouseout'){
             console.log("鼠标移出事件");
         }
     })
 })
```

## XML文件

* xml是可扩展的标记性语言
* 1. xml可以用来保存数据
  2. 还可以为项目或者模块做配置文件
  3. 还可以作为网络传输数据的格式

### xml语法介绍

``` xml
<?xml version="1.0" encoding="utf-8" ?>
<!-- <?xml version="1.0" encoding="utf-8" ?>是xml文件的声明
      version表示版本
      encoding表示xml文件用的编码
  -->
<books>          <!-- 表示多种书 -->
    <book Num="1234589">  <!-- 表示一本书 -->
        <name>时间简史</name>  <!-- 表示书名 -->
        <price>100</price>   <!-- 表示书价格 -->
        <autor>霍金</autor>   <!-- 表示书坐着 -->
    </book>
</books>
```

* **xml元素命名规则**
  1. 名称可以包含字符和数字包括其他字符
  2. 名称不能以数字或者标点符号开头
  3. 名称不能包含空格

* **xml文件里面只能有一个根元素(根元素就是最高级元素，没有父元素)**
* **xml文件使用特殊字符是(例如：<>)，需要使用转义字符------$gt;   $lt;**
* **xml文件里面如果有太多特殊字符，可以使用CDATA区（文本区域）--(<![CDATA[这里可以输入文本，xml不做解析]]>**) 

### 使用dom4j解析xml文件

* **提供的xml文件实例**

  ``` xml
  <?xml version="1.0" encoding="UTF-8"?>
  
  <books>
      <book sn="SN12341232">
          <name>辟邪剑谱</name>
          <price>9.9</price>
          <author>班主任</author>
      </book>
  
      <book sn="SN12341231">
          <name>葵花宝典</name>
          <price>99.99</price>
          <author>班长</author>
      </book>
  </books>
  ```

* **创建java工程**
* * 首先需要src下创建xml实体类，用来解析xml里元素
  * 提供构造器，get/set方法，toString方法
  * 引入dom4j.jar包
  * * 在当前module下创建一个lib目录(new Directory)，将jar包粘贴进lib目录，然后鼠标右击，点击Add as Library，在弹出的窗口中点击level下的Module Library（只能在当前Module下使用该jar包），project Library可以在所有Module下使用jar包 

* **创建解析测试类,具体如下：**

* * ``` java
    @Test
       public void Test1() throws Exception {
           //获取saxReader对象，读取xml文件，获得文档对象
           SAXReader saxReader = new SAXReader();
           Document document = saxReader.read("src/books.xml");
      
           //获取根元素
           Element rootElement = document.getRootElement();
           //用根元素获取book标签对象
           //elements()和element()方法都是通过标签名查找子元素
           //Element book1 = rootElement.element("book");
           List<Element> books = rootElement.elements("book");
           for(Element book : books){
               //asXML()将标签语言转换为标签字符串
               //System.out.println(books.asXML());
               //Element name = book.element("name");
               //System.out.println(name.asXML());
               //getText()方法获取标签文本
               //System.out.println(name.getText());
      
               //直接获取子元素标签的文本内容
               String name = book.elementText("name");
               String price = book.elementText("price");
               String author = book.elementText("author");
               String snValue = book.attributeValue("sn");
               //生成书的实体对象
               System.out.println(new Books(name,Double.parseDouble(price),author,snValue));
      
           }
           
           运行结果：
               Books{name='辟邪剑谱', price=9.9, author='班主任', num='SN12341232'}
      			Books{name='葵花宝典', price=99.99, author='班长', num='SN12341231'}
    ```

## Tomcat

### 目录介绍

* bin：专门用来存放Tomcat的可执行程序
* conf ：专门用来存放Tomcat服务器的配置文件
* lib：专门用来存放Tomcat服务器的jar包
* logs：专门用来存放Tomcat服务器运行时输出的日记信息
* temp：专门用来存放Tomcat服务器运行时产生的临时数据
* webapps：专门用来存放Tomcat服务器部署的web工程
* work：是Tomcat工作时的目录，用来存放Tomcat运行时jsp翻译为Servlet的源码，和session钝化的目录

### 如何启动Tomcat服务器

* 在Tomcat目录下找到bin目录，找到lib目录下的startup.bat文件，双击计即可
* 在命令号中对应的目录下输入catalina run，即可启动

### 如何测试Tomcat已成功开启

* 打开浏览器，在浏览器地址栏上输入以下地址

* 1. http://localhost:8080
  2. http://120.0.0.1:8080

### 如何停止Tomcat服务器

* 在Tomcat目录下的bin目录下找到shutdown.bat双击即可停止
* 直接关闭Tomcat命令行窗口

### 如何修改Tomcat的端口号

* Tomcat默认端口号8080

* 找到Tomcat目录下的conf目录下的servlet.xml，找到<connector>标签，修改port的值（1000-65535），然后重启即可

### 部署web工程的两种方式

1. 只需要把web工程拷贝到Tomcat目录下的webapps下即可，然后再浏览器中输入http://ip:8080/webname/lib/lib..
2. 在Tomcat目录下的conf下的Catalina下的localhost创建配置文件，具体内容如下，

``` xml
<Context path="/myWeb" docBase="F:\javaWeb\资料\java-install-jar\apache-tomcat-8.0.50\books" />
<!-- path:表示创建的配置文件名
	 docBase：表示当前的web工程目录路径 
-->
```

3. 然后再浏览器中输入http://ip:8080/配置文件名/lib/lib..

## 如何创建web工程

* 首先需要部署Tomcat和idea的连接

* 1. 在settings下的Build...找到Application Servers，添加Tomcat服务器。如果没有Tomcat需要在plugins搜索Tomcat and TomEE
  2. apply此插件，然后在Application Servers添加即可
* 在当前工程下新创建一个module，选择java EE，选择web Application(4.0)，然后创建即可

### 了解web - Module目录

* src用来java代码
* web目录专门用来存放web工程的资源文件WEB-INF是受保护的目录栏，浏览器无法直接访问到此目录的内容
* 一般在web目录下还应创建一个lib目录，用来存放jar包

## Servlet技术

### 什么是Servlet

* Servlet是java EE规范之一（接口）

* Servlet是三大组件之一。三大组件分别是：Servlet程序，filter过滤器，Listener监听器
* Servlet是运行在服务器上的java小程序，他可以接收客户端发来的请求，并响应数据给客户端

### 手动实现Servlet程序

* 编写一个类实现Servlet接口
* 实现service方法处理请求，并响应数据
* 到web.xml中区配置servlet程序的访问地址



### Servlet程序的访问

* 客户端浏览器通过ip地址找到服务器
* 客户端浏览器通过端口号找到Tomcat
* 客户端浏览器通过工程名找到对应的工程
* 客户端浏览器通过资源路径令服务器加载配置文件，找到servlet类名
* 进行servlet方法的运行

![1](F:\javaWeb\资料\截图\1.png)

### servlet的生命周期

1. 执行构造器方法
2. 执行init初始化方法
3. 执行service方法
4. 执行销毁方法

* 第一步和第二部都是只执行一次
* 第三步刷新一次服务器就执行一次
* 第四步只会在服务器关闭的时候执行

### Servet的请求分发处理

* 需要在service方法中判断客户端的请求是GET/POST，然后将requestServlet转换为HttpServlet类型

* 调用getmethod方法，判断请求是GET/POST

* 测试如下：

* ``` xml
  <form action="http://localhost:8080/02_Servlet_war_exploded/HttpServlet" method="post">
          <input type="submit">
      </form>
  ```

* ``` java
  @Override
      public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
          //当请求是get/post时,需要判断是那个请求，将servletRequest转换为他的子接口HttpServletRequest，调用器getMethod方法
          HttpServletRequest request = (HttpServletRequest) servletRequest;
          String method = request.getMethod();
          if("GET".equals(method)){
              doGET();
          } else if("POST".equals(method)){
              doPOST();
          }
      }
  ```

### HttpServlet类

* 一般在开发中都是用继承Httpservlet类对业务进行处理

* ``` java
  public class TestHttpServlet extends HttpServlet {
  
      @Override
      protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          System.out.println("HttpServlet的get方法");
      }
  
      @Override
      protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          System.out.println("HttpServlet的post方法");
      }
  }
  ```

### IDEA菜单生成Servlet程序

* 在当前的包下new--》create Servlet，直接生成然后在弹出的窗口上设置name(类的别名)，全类名

### Servlet类的继承体系

![](F:\javaWeb\资料\截图\2.png)

### ServletConfig类的了解

* 可以获取Servlet-name值，就是别名

* 可以获取init-param的value

* ``` xml
  <servlet-class>com.dajiao.servlet.TestServlet</servlet-class>
          <init-param>
              <param-name>url</param-name>
              <param-value>jdbc:mysql://localhost:8080</param-value>
          </init-param>
          <init-param>
              <param-name>username</param-name>
              <param-value>mysql</param-value>
          </init-param>
      </servlet>
  ```

* 可以获取ServletContext对象

* ``` java
  @Override
      public void init(ServletConfig servletConfig) throws ServletException {
  //        System.out.println("2. 执行init初始化方法");
          //可以获取servlet程序的别名
          String servletName = servletConfig.getServletName();
          System.out.println("servlet-name的别名是" + servletName);
          //可以获取初始化参数init-param
          String url = servletConfig.getInitParameter("url");
          String username = servletConfig.getInitParameter("username");
          System.out.println(url);
          System.out.println(username);
          //获取ServletContext()对象
          System.out.println(servletConfig.getServletContext());
      }
  ```
  * ***当类继承的是HttpServlet的时候，重写init方法时，必须调用父类的init方法***

### ServletContext对象的作用

* 可以获取context-param的值

* 获取当前的工程路径

* 获取在磁盘上的绝对路径

* 想map一样存储数据

* ``` java
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
          //获取context-param值，context-param是web.xml文件的全局值，所有的Servlet程序公用
          ServletContext context = getServletConfig().getServletContext();
          String password = context.getInitParameter("password");
          System.out.println(password);
  
          //获取当前的工程路径
          System.out.println("工程路径" + context.getContextPath());
  
          //工程部署的路径
          String realPath = context.getRealPath("/");
          System.out.println(realPath);
  
      }
  ```

* 一个web工程，只能实例化一个ServletContext队对象，ServletContext对象存储数据在web工程开始之后数据是公用的

* ``` java
  public class ServletContext1 extends HttpServlet {
  
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          ServletContext context = getServletContext();
          System.out.println("context存储的数据" + context.getAttribute("key"));
  
          context.setAttribute("key","value");
          System.out.println("context存储的数据" + context.getAttribute("key"));
          System.out.println("context存储的数据" + context.getAttribute("key"));
          System.out.println("context存储的数据" + context.getAttribute("key"));
      }
  }
  
  public class ServletContext2 extends HttpServlet {
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
      }
  
      protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          ServletContext context = getServletContext();
          System.out.println(context.getAttribute("key"));
      }
  }
  
  
  ```

* ![](F:\javaWeb\资料\截图\3.png)第一次运行ServletContext1

* ![](F:\javaWeb\资料\截图\4.png)第一次运行ServletContext2

* ![](F:\javaWeb\资料\截图\5.png)第二次运行ServletContext1，**三次运行服务器没有中断！！**

* 证明ServletContext对象在服务器开启之后存储的数据是公用的，***因为此对象是唯一的。***

## HTTP协议

* **所谓HTTP协议就是客户端和服务器之间的通信时，发送的数据，需要遵守的协议，就是HTTP协议**、
* HTTP的协议中的数据又叫报文



### HTTP协议的内容

* **GET**

![](F:\javaWeb\资料\截图\6.png)

* **POST**

![7](F:\javaWeb\资料\截图\7.png)

### 常用的请求头

* **Accept**：表示客户端可以接受的数据类型

* **Accept-language**：表示客户端可以接受的语言类型
* **user-Agent**：表示客户端浏览器的信息
* **host**：表示请求时服务器的ip和端口号

### 常用的 GET请求和POST请求

* GET
  * form标签--method= get
  * img标签传输图片
  * iframe标签
  * a标签跳转页面
  * linked标签引入css文件
  * script标签引入js文件
  * 在浏览器地址敲回车
* POST
  * form标签--method= post

### 常用的响应码说明

* 200：表示服务器收到数据，并且回传数据
* 404：表示服务器收到了，但是没有你要的数据
* 302：表示重定向
* 500：表示服务器收到了，但是服务器内部错误

### HttpServletRequest类的使用

* 可以获取资源路径
* 可以获取统一的资源定位符--绝对路径
* 可以获取请求头
* 可以获取客户端的ip地址
* 可以获取请求方式

``` java
public class TestServletRequest extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的资源路径
        System.out.println("URI--->>" + request.getRequestURI());
        //获取统一资源定位符--绝对路径
        StringBuffer requestURL = request.getRequestURL();
        System.out.println("工程的绝对路径--" + requestURL);
        //获取客户端的ip地址
        System.out.println("客户端的ip地址：" + request.getRemoteHost());
        //获取请求头
        System.out.println("请求头：" + request.getHeader("User-Agent"));
        //获取请求方式
        System.out.println("请求方式："+ request.getMethod());
    }
}
```

![](F:\javaWeb\资料\截图\8.png)

* 获取请求参数
* 测试：

``` xml
创建html文件
<body>
    <form action="http://localhost:8080/03_Servlet/parameterServlet" method="get">
        用户名：<input type="text" name="username" id="username1"><br>
        用户密码：<input type="text" name="password" id="password1"><br>
        <input type="checkbox" name="hobby" value="c++">c++
        <input type="checkbox" name="hobby" value="java">java
        <input type="checkbox" name="hobby" value="js">javaScript<br>
        <input type="submit" >
    </form>
</body>
```

```java
public class ParameterServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //request.getparameter()是获取单选项
        String[] hobbies = request.getParameterValues("hobby");

        System.out.println(username);
        System.out.println(password);
        for(String str : hobbies){
            System.out.println(str);
        }
    }
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
        //post请求必须首先设置字符集为UTF-8，不然会出现中文乱码问题
        request.setCharacterEnconding("UTF-8");
        //获取请求参数信息
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //request.getparameter()是获取单选项
        String[] hobbies = request.getParameterValues("hobby");

        System.out.println(username);
        System.out.println(password);
        for(String str : hobbies){
            System.out.println(str);
        }
     }
}
```

* 运行结果

![](F:\javaWeb\资料\截图\14.png)**post没有设置字符集，导致中文乱码**

![](F:\javaWeb\资料\截图\9.png)***post请求必须首先设置字符集为UTF-8，不然会出现中文乱码问题***



### Servlet请求转发的特点

* 浏览器请求servlet1，servlet1执行后直接转发到servlet2，servlet2回传数据给浏览器

![](F:\javaWeb\资料\截图\10.png)

* 测试：

```java 
public class Servlet1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数（材料）
        String username = request.getParameter("username");
        System.out.println("Servlet1获取的参数---"+username);

        //给材料盖个章
        request.setAttribute("key","Servlet1阿巴巴盖章");

        //获取Servlet2的路径
        // / 斜杠代表绝对路径http://localhost:8080/工程名  映射到了IDEA的web目录
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");

        //转到Servlet2执行程序
        requestDispatcher.forward(request,response);
    }
}

public class Servlet2 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        String username = request.getParameter("username");
        System.out.println("Servlet2获取的参数--" + username);

        //看看Servlet1是否盖了章
        Object key = request.getAttribute("key");
        System.out.println("Servlet2获取的章---" + key);

        //执行自己的业务
        System.out.println("Servlet2执行自己的业务~~~~");
    }
}
```

![](F:\javaWeb\资料\截图\11.png)**运行结果**



### base标签的使用

* 测试

``` xml
<body>
   
    首页<br>
    <a href="a/b/c.html">a下的b下的c.html页面</a><br>
    <a href="http://localhost:8080/03_Servlet/forward">从forward跳转</a>
</body>

<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <base href="http://localhost:8080/03_Servlet/a/b/c.html">
</head>
<body>
    a下的b下的c.html标签<br>
    <a href="../../pose.html">回到首页</a>
</body>
```

``` java
public class Forward extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("经过了FOWARD标签");
        //跳转到a下的b下的c.html
        request.getRequestDispatcher("/a/b/c.html").forward(request,response);
    }
}
```

![](F:\javaWeb\资料\截图\12.png)

#### web中的路径

* 相对路径
  * **.** 表示当前路径
  * **..** 表示上一级目录
  * 资源名：表示当前目录/资源名
* 绝对路径
  * http://ip:8080/工程名/资源路径

### web斜杠的不同意义

* 在浏览器中，斜杠被解析成http://ip:port/,例如：

``` xml
<a href="/"></a>
```

* 在服务器中斜杠被解析成http://ip:port/工程名,例如：

```java 
1.<url-pattrn>/servlet</url-pattrn>
2.servletContext.getRealPath("/")
3.reuquest.getrequestDispatcher("/")
```

* 特殊情况：request.sendRediect("/"),这个斜杠会送到浏览器解析得到http://ip:port/

### HttpServletResponse类的介绍

* 在每次客户端发送请求过来，Tomcat服务器都会创建一个HttpServletResponse对象
* 我们可以设置HttpServletResponse对象对浏览器进行响应数据

#### 两个响应流

* **witer字符流**
* **OutputStream字节流**
* **两个响应流在程序中只能使用一个**

#### 解决响应中文乱码问题

* 在程序中，需要设置响应头的接收数据类型，服务器和客户端浏览器的字符集需要设置成UTF-8

``` java
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置服务端的字符集为UTF-8
//        response.setCharacterEncoding("UTF-8");
        //设置客户端的字符集为UTF-8
        //content-type：发送的数据类型  text/html就是发送的文本类型  charset=UTF-8设置字符集
//        response.setHeader("content-type","text/html; charset=UTF-8");
        //输出字符集类型
//        System.out.println(response.getCharacterEncoding());
        //另外的方法,可以同时设置服务器和浏览器的字符类型,此方法需要在获取响应流对象之前设置
        response.setContentType("text/html; charset=UTF-8");
        //获取字符响应流
        PrintWriter writer = response.getWriter();
        //响应类容
        writer.write("中文不乱吗");
    }
```

### 重定向

![](F:\javaWeb\资料\截图\13.png)

``` java
测试：
public class response1 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //回复响应码
//        response.setStatus(302);
        //设置响应头
//        response.setHeader("Location","http://localhost:8080/03_Servlet/response2");
        //第二种方法
        response.sendRedirect("http://localhost:8080/03_Servlet/response2");
    }
}

public class response2 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().write("response2 result!!!");
    }
}
```

## 书城项目

### JDBC回顾

* 数据库连接池

  * 阿里巴巴Druid的使用

    * java连接数据库需要引入驱动jar包，使用Druid需要引入jar包

    * 连接数据库还需要一个配置文件druid.properties

      ``` java 
      //首先编写JDBCUtils类来获取连接和关闭连接
      public class JDBCUtils{
          DataSource dataSource = null;
          //静态代码块，在类加载后就加载的代码
          static{
              try{
                  //获取配置文件的输入流
                  FileInputStream inputStream = 			      			JDBCUtils.class.getClassLoader().getResourceAssStream("druid.properties");
                  //创建配置文件
                  Properties properties = new Properties();
                  //读入配置文件
                  properties.load(inputStream);
                  //加载驱动
                  dataSource = DruidDataSourceFactory.createDataSource(properties);
              } catch (Exception e){
                  e.printStackTrace();
              }
          }
          
          //创建静态的获取连接方法
          public Connection getConnection(){
              Connection connection = null;
              try{
             	 	connection = dataSource.getConnection();
                  return connection;
              }catch (Exception e){
                   e.printStackTrace();
              }
              return connection;
          }
          //创建关闭连接方法
          public void close(){
              try {
                  connection.close();
              } catch (SQLException throwables) {
                  throwables.printStackTrace();
              }
          }
         
      }
      ```

  * **使用dbUtils来执行mysql的增删改查**

``` java

//然后编写Dao类的BasicDao方法
public class BasicDao{
    //需要引入dbUtilsjar包
    //调用dbUtils的QueryRunner对象，可以用编写mysql增删改查
    QueryRunner qr = new QueryRunner();
    
    
    public int update(String sql,Object...params){
        Connection connection = null;
        try{
            connection = JDBCUtils.getConnection();
            int update = qr.update(connection,sql,params);
            //返回影响的行数
            return update;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JDBCUtls.close(connection);
        }
    }
    
    public <T> T querySingle(String sql, Class<T> c, Object...params){
        Connection connection = null;
        try{
            connection = JDBCUtils.getConnection();
            T query = qr.query(connection,sql,new BeanHandler(c),params);
            return query;
        }catch (Excption e){
             e.printStackTrace();
        }finally{
            JDBCUtls.close(connection);
        }
    }
    
    public <T> List<T> queryMuti(String sql, Class<T> c, Object...params){
        Connection connection = null;
        try{
            connection = JDBCUtils,getConnection();
            List<T> list = qr.query(connection,sql,new BeanListHandler(c),params);
            return list;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JDBCUtls.close(connection);
        }
    }
    
    public Object queryScale(String sql,Object...params){
        Connection connection = null;
        tyr{
            connection = JDBCUtils.getConnection();
            Object o = qr.query(connection,sql,new ScaleHandler(),params);
            return o;
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            JDBCUtls.close(connection);
        }
    }
}

实体类User
    package dajiao.pojo;

/**
 * @program: javaWebWork
 * @description:实体类，用于存放客户信息
 * @author: Mr.Yu
 * @create: 2020-11-11 21:18
 **/
public class User {

    private Integer id;
    private String username;
    private String password;
    private String email;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(Integer id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

```

### Dao的建立

* 编写UserDao接口，定义规范

* ``` java 
  public interface userDao {
  
      /**
       * @Description: 根据用户名获取用户信息,如果用户不存在，返回null，存在返回user
       * @Param: [username]
       * @return: dajiao.pojo.user
       * @Author: Mr.Yu
       * @Date: 2020/11/12
       */
      public User getUserByUsername(String username);
  
      /**
       * @Description: 验证是否存在用户，存在返回user，不存在返回null
       * @Param: [username：用户名, password：密码]
       * @return: dajiao.pojo.user
       * @Author: Mr.Yu
       * @Date: 2020/11/12
       */
      public User getUserByNamePassWord(String username, String password);
  
      /**
       * @Description: 用于保存用户信息到数据库
       * @Param: [user：用户注册的所有信息]
       * @return: int
       * @Author: Mr.Yu
       * @Date: 2020/11/12
       */
      public int saveUser(User user);
  }
  ```

* 实现UserDao接口

* ``` java
  public class UserDaoImpl extends BasicDao implements UserDao{
  	
  	public User getUserByUsername(String username){
  		String sql = "select id,username,password,email from t_user where username = ?";
          return querySingle(sql,User.class,username);
  	}
      
      public User getUserByNamePassWord(String username, String password){
          String sql = "select id,username,password,email from t_user where username = ? and password = ?";
          return querySingle(sql,User.class,username.password);
      }
  	
      public int saveUser(User user){
          String sql = "insert into t_user values(?,?,?,?)";
          return update(sql,null,user.getUsername(),user.getPassword(),user.getEmail());
      }
  }
  ```

### Service类

* 编写业务类接口，定义好规范

* ```java
  public interface userServiceInterface {
  
      /**
       * @Description: 用来判断注册时用户名是否存在
       * @Param: [username：注册时的用户名]
       * @return: java.lang.Boolean
       * @Author: Mr.Yu
       * @Date: 2020/11/12
       */
      public Boolean existUser(String username);
  
      /**
       * @Description: 用于登陆页面时，验证用户名和密码手否正确
       * @Param: [username：输入的用户名, password：输入的密码]
       * @return: dajiao.pojo.User
       * @Author: Mr.Yu
       * @Date: 2020/11/12
       */
      public User loginUser(String username, String password);
  
      /**
       * @Description: 注册用户，保存数据
       * @Param: [user]
       * @return: void
       * @Author: Mr.Yu
       * @Date: 2020/11/12
       */
      public void registUser(User user);
  
  }
  
  //实现接口方法
  public class UserService{
      UserDaoImpl userDao = new UserDaoImpl();
      
      public boolean existUser(String username){
          return userDao.getUserByUsername(username) == null;
      }
      
      public User loginUser(String username, String password){
          return userDao.getUserByNamePassWord(username,password);
      }
      
      public void registUser(User user){
          userDao.saveUser(user)
      }
  }
  ```

### web类

* 注册业务

```java
public class RegisetServlet{
    UserService userService = new UserService();
    
    public void doPost(HttpServletRequset requset, HttpServletresponse response){
        //获取注册的值
        String username = requset.getParamter("username");
        String password = requset.getParamter("password");
        String email = requset.getParamter("email");
        String code = requset.getParamter("code");
        
        //判断验证码是否输入正确
        if("abcde".equals(code){
         	//验证码正确，判断客户名是否已经存在
            if(userService.existUser(username)){
                //不存在，将客户的信息存入数据库中,跳到注册成功页面
                System.out.println("注册成功")
                userService.saveUser(new User(null,username,password,email));
                request.getRequsetDispatcher("/pages/user/regist_success.html");
            } else {
                //存在，跳回注册页面
                System.out.println("用户名已存在")
                request.getRequsetDispatcher("/pages/user/regist.html");
            }
        } else {
            //验证码错误，跳回注册页面
            System.out.println("验证码错误")
            request.getRequsetDispatcher("/pages/user/regist.html");
        }
    }
}
```

* 登录业务

```java
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //验证是否有此用户，有就跳转到success-login，没有就跳到登录页面
        if (userService.loginUser(username, password) == null){
            System.out.println("用户名或者密码错误");
            request.getRequestDispatcher("/pages/user/login.html").forward(request,response);
        } else {
            request.getRequestDispatcher("/pages/user/login_success.html").forward(request,response);
        }

    }

}
```

## IDEA的debug调试

![](F:\javaWeb\资料\截图\18.png)

![](F:\javaWeb\资料\截图\17.png)

## jsp

### 什么是jsp

* jsp全称是java server pages，java的服务器页面
* jsp的主要作用是代替Servlet程序回传html页面的数据
* 由于Servlet程序回传页面数据是一件很复杂的事情，开发和维护成本都很高

### jsp的本质是什么

* 当我们第一次访问jsp文件时，Tomcat服务器会帮我们把jsp文件页面翻译成一个java源文件，并对他编译成为.class文件字节码程序
* 打开Java源文件发现HTTPJSBase类直接继承了HttpServlet类，也就是jsp翻译出来的类，继承了HttpServlet类，相当于翻译出来了一个Servlet程序。

### jsp头部的page指令

* jsp的page指令可以修改jsp页面的一些重要的属性，或者行为

``` jsp
<%@ page contentType="text/html;charset=UTF-8" 
    pageEncoding="utf-8"
    errorPage = "/错误页面.html"
    language="java" %>

1.lauguage属性： 表示jsp被翻译成什么语言文件，默认是java，目前只支持java
2.contentType属性：表示jsp返回的数据类型是什么
3.pageEncoding属性：表示jsp页面本身的字符集类型，一般设为utf-8
4.import属性：和java语言的功能一样
5.autoFlush属性：设置out输出缓冲流满了之后。是否自动刷新缓冲区，默认是true
6.buffer属性：设置out输出缓冲区的大小，默认是8kb
7.errorPage属性：设置当jsp语言出现错误时，跳转到指定页面，在jsp中'/'直接映射到web目录
8.isErrorPage属性：设置当前的jsp页面是否是错误信息页面，默认是false，如果是true乐意获取异常信息
9.session属性：设置访问当前的jsp页面，是否会创建httpsession对象，默认是true
10.extends属性：设置jsp翻译做出来的类继承谁
```

### jsp中常用的脚本

#### 声明脚本

```jsp
<%@ page contentType="text/html;charset=UTF-8"

         language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%-- 在jsp中定以类的属性 --%>
    <%!
        private int id;
        private String name;
        private static Map<String,Object> map;
    %>
<%--  在jsp中生成静态代码块  --%>
    <%!
        static{
            map = new HashMap<>();
            map.put("key1","value1");
            map.put("key2","value2");
            map.put("key3","value3");
        }
    %>
<%-- 在jsp中生成方法 --%>
    <%!
        public void method(){
            System.out.println(1);
        }
    %>
<%-- 在jsp中生成内部类 --%>
    <%!
        public class A{
            private int num;
        }
    %>
</body>
</html>

```

#### 表达式脚本（常用）

* 表达式脚本的格式是：<%=表达式%>
* 表达式脚本的作用是：在jsp页面输出数据
* 表达式脚本的特点
  1. 所有的表达式脚本都会被翻译到_jspServcie()方法中，
  2. **表达式脚本都会被翻译成为out.print()输出到网页页面上**
  3. 由于表达式脚本都会被翻译到__jspService()方法中，所以_jspService()方法中的对象都可以使用
  4. 表达式脚本中不能出现分号

``` jsp
<%-- 输出整型数据 --%>
    <%=12%><br>

    <%-- 输出浮点数据 --%>
    <%=12.12%><br>

    <%-- 输出字符串 --%>
    <%="我是字符串"%><br>


    <%-- 输出对象 --%>
    <%=map%><br>


    <%-- 调用_jspService()方法中的对象 --%>
    <%=request.getParameter("username")%><br>

输出结果：  网址栏：http://localhost:8080/04_jsp/a.jsp?username=laoyu
12
12.12
我是字符串
{key1=value1, key2=value2, key3=value3}
laoyu
```

#### 代码脚本

* 代码脚本的格式是    --   **<%  java 语句  %>**
* 代码脚本的功能是：可以在jsp页面上，编写我们自己需要的功能
* 代码脚本的特点是
  1. 代码脚本翻译之后都在_jspService()方法中
  2. 由于代码脚本都被翻译到_jspService()方法中，所以在jspService方法中的所有对象都可以使用
  3. **还可以用多个代码脚本组合成完整的java语句**

```jsp
<%--  if语句  --%>
    <%
        int x = 1;
        if(x == 2){
    %>
            <h1>你好啊</h1>
    <%
        } else {
    %>
             <h1>丑八怪</h1>
    <%
        }
    %>
<%--   for循环语句  和表达式脚本混合使用  --%>
    <table border="1" cellspacing="0" bgcolor="white">
    <%
        for(int i=0; i<10; i++){
    %>
        <tr>
            <td><%=i%></td>
        </tr>
        <%
        }
    %>
    </table>

<%--   调用_jspService()方法中的对象  --%>
    <%
        String username = request.getParameter("username");
        System.out.println(username);
    %>
页面显示：
丑八怪
0
1
2
3
4
5
6
7
8
9
```

### jsp的九大内置对象

```java
public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    java.lang.Throwable exception = org.apache.jasper.runtime.JspRuntimeLibrary.getThrowable(request);
    if (exception != null) {
      response.setStatus(javax.servlet.http.HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
    }
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;
```

* HttpServletRequest  	request		请求对象
* HttpServletResponse    response        回应对象
* pageContext                                        jsp的上下文对象
* session                                                会话对象
* exception                                         异常对象
* config                                                ServletConfig对象
* Application                                      ServletContext对象
* out                                                  jsp输出对象
* page                                              指向当前的jsp对象

### jsp的四大域对象

* **四大域对象分别是**
  1. pageContext对象：（PageContextImpl类）   在当前jsp页面范围有效
  2. request对象：（HttpServletRequest类）  依次请求范围有效
  3. session对象： （HttpSession类）  一次会话范围内有效（打开浏览器访问服务器，直到关闭浏览器）
  4. application对象：（Context对象） web工程范围都有效
* 域对象虽然都可以存储数据，但是因为其范围不一样，所以在使用它们时是有优先顺序的
  * **pageContext ----》》 request ----》》 session ----》》 application**
* 因为范围越小，数据就会越早被清除，释放存储空间

### jsp中out输出和response.getWriter()的区别

![](F:\javaWeb\资料\截图\20.png)

* 由于jsp翻译之后，底层源代码都是用out输出。所以一般情况下，我们都是用的out来进行网页页面输出，避免打乱页面的输出顺序
* out.witer()输出字符串是没有问题 的
* out.print()输出任何数据类型都没有问题，都调用了字符串转型----out.print(String.valueOf(Object obj))
* out.writer(num)输出的时候，char[capacity++] = (char) num,会把数字转换成字符，导致输出的结果不理想
* 得出结论：**在jsp中我们都用out.print输出**

### jsp常用的标签

#### 静态标签

* **静态标签的表示方法**

  ``` xm
  <%@ include file="指定jsp文件路径"%>
  ```

* **静态标签包含的特点**

  * 静态包含不会翻译被包含的jsp页面
  * 静态包含其实就是把包含的jsp代码脚本拷贝到包含的输出位置

#### 动态包含

![](F:\javaWeb\资料\截图\21.png)

* 动态包含表达方式：

  ```xml
  <jsp:include page="指定jsp文件路径"></jsp:include>
  ```

* 动态包含会翻译包含的jsp页面称为java源代码

* 动态包含将包含的jsp代码翻译成以下的java代码进行输出

  ```java
  JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
  ```

* 动态包含还可以传递参数

   ```jsp
  <jsp:include page="指定jsp文件路径">
      <jsp:param name="username" value="www"></jsp:param>
  </jsp:include>
  
  <!-- 在jsp指定文件路径获取参数 -->
  <%= requset.getparameter("username")>
  ```

#### 请求转发标签

* ```jsp
  <jsp:forward page="指定请求转发的路径"></jsp:forward>
  ```

## Listener监听器

### 什么是Listener监听器

* Listener监听器是javaweb的三大组件之一
* Listener监听器是javaEE的规范，就是接口
* 其作用时监听事物的变化，然后回调函数，反馈给客户去做一些相应的处理

### ServletContextListener监听器

* ServletContextListener监听器可以监听对象ServletContext对象销毁和创建
* ServletContext对象在web创建时生成，在web停止后销毁
* 监听到创建和销毁之后都会分别调用ServletContextListener监听器的方法反馈

``` java
public class ServletContextListenerImpl implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象创建了");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象销毁了");
    }
}
```

## EL表达式和JSTL标签库

* EL表达式的全称是Expression Language，表达式语言，
* EL表达式的作用：代替jsp页面中的表达式脚本在jsp页面上进行数据的输出
* EL表达式比jsp的表达是脚本简洁很多
* EL表达式输出的额格式是    -----       **${表达式}**
* EL表达式输出null值的时候，输出空串，jsp输出null

``` jsp
    <%
        request.setAttribute("key","object");
    %>

    jsp表达式key里面的值是：<%= request.getAttribute("key") %><br>
    EL表达式key里面的值是：${key}
```

### EL表达式输出域对象中的数据的顺序

* EL表达式在jsp页面中输出的数据，主要是域对象中的数据
* 当四个域都存有相同的key值时，EL表达式会按照域对象的请求范围从小到大的输出最小域的对应的值

```jsp
<%
        pageContext.setAttribute("key","pageContext");
        request.setAttribute("key","request");
        session.setAttribute("key","session");
        application.setAttribute("key","application");
    %>
    ${ key }
```

### EL表达式输出bean对象

```jsp
public class Person{
	......
	//person中无age属性，但有getAge方法
}

<%
        Person person = new Person();
        person.setName("广哥大英雄");

        String[] phones = {"12345678","78945612","456789123"};
        person.setPhones(phones);

        List<String> cites = new ArrayList<>();
        cites.add("北京");
        cites.add("上海");
        cites.add("贵阳");
        person.setCites(cites);

        Map<String, Object> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        person.setMap(map);

        pageContext.setAttribute("person",person);
    %>

    ${ person }<br>
    person的name值：${person.name}<br>
    person的phones各个元素值：${person.phones}<br>
    person的phones个别元素值：${person.phones[0]}<br>
    person的cities各个元素值：${person.cites}<br>
    person的cities个别元素值：${person.cites[1]}<br>
    person的map个别元素值：${person.map.key1}<br>
    person的年龄值：${person.age}
```

* EL表达式输出Bean对象是时，不看属性，只看有无get方法。

### EL表达式的运算

#### EL表达式的关系运算

![](F:\javaWeb\资料\截图\22.png)

#### 逻辑运算

![](F:\javaWeb\资料\截图\23.png)

### empty运算

* empty运算可以判断一个数据是否为空，是空就输出true，不为空就输出false
* 以下几种情况输出true
  * 当值为null时，输出true
  * 当值为空串时，输出true
  * 当输出元素个数为零时，输出true
  * 当list元素个数为零时。输出true
  * 当map元素个数为零时，输出true

* ${  **empty**   值 }

### EL表达式的十一个隐含对象

| 变量             | 类型                 | 作用                                         |
| ---------------- | -------------------- | -------------------------------------------- |
| pageContext      | pageContextImpl类    | 获取jsp的九大内置对象                        |
| pageScope        | Map<String,  Object> | 可以获取pageContext域中的数据                |
| requestScope     | Map<String,Object>   | 可以获取request域 中的数据                   |
| sessionScope     | Map<String,Object>   | 可以获取session域 中的数据                   |
| applicationScope | Map<String,Object>   | 可以获取application域 中的数据               |
| param            | Map<String,String>   | 可以获取请求参数的值                         |
| paramValues      | Map<String,String[]> | 可以获取请求参数的值，获取多个值的时候用     |
| header           | Map<String,String>   | 可以获取请求头的值                           |
| headerValues     | Map<String,String[]> | 可以获取请求头的值，获取多个值的情况         |
| cookie           | Map<String,cookie>   | 可以获取当前请求cookie的值                   |
| initParam        | Map<String,String>   | 可以获取在web.xml中上下文context-param的参数 |

#### 获取EL表达式的特定域的值

```jsp
<%--  获取特定的域的值  --%>
    <%
        pageContext.setAttribute("key1","pageContext");
        request.setAttribute("key1","request");
        session.setAttribute("key1","session");
        application.setAttribute("key1","application");
    %>

    pageContext的值是：${ pageScope.key1 }
    request的值是：${ requestScope.key1 }
    session的值是：${ sessionScope.key1 }
    application的值是：${ applicationScope.key1 }
```

#### pageContext对象的使用

``` jsp
	
	jsp表达式脚本：
	协议：<%=  request.getScheme() %>
	服务器ip：<%=  request.getServerName() %>
	获取服务器端口：<%=  request.getServerPort() %>	
	获取工程路径：<%=  request.getContextPath() %>
	获取请求方法：<%=  request.getMethod() %>
	获取会话的唯一标识：<%=  session.getID() %>
	获取客户端的ip地址：<%=  request.getRemoteHost() %>
	获取资源路径：	<%=  request.getServletPath() %>

	EL表达式的方法：
	1.协议：${ pageContext.request.scheme }<br>
    2.服务器ip：${ pageContext.request.serverName }<br>
    3.获取资源路径：${ pageContext.request.servletPath }<br>
    4.获取请求方法：${ pageContext.request.method}<br>
    5.获取服务器端口：${ pageContext.request.serverPort }<br>
    6.获取会话的唯一标识：${ pageContext.session.id }<br>
    7.获取客户端的ip地址：${ pageContext.request.remoteHost }<br>
    8.获取工程路径：${ pageContext.request.contextPath  }

输出：
	1.协议：http
    2.服务器ip：127.0.0.1
    3.获取资源路径：/pageContext.jsp
    4.获取请求方法：GET
    5.获取服务器端口：8080
    6.获取会话的唯一标识：F38CEE37C65BBC8481FCF535316731A5
    7.获取客户端的ip地址：127.0.0.1
    8.获取工程路径：/06_EL_JSTL 

```

#### 其他对象

* 浏览器的网址是：http://127.0.0.1:8080/06_EL_JSTL/otherObj.jsp?username=param&password=123456&hobby=java&hobby=jsCrript

```jsp
	username的值是：${ param.username }<br>
    password的值是：${ param.password }<br>
    <hr>
    hobby的第一个值是：${ paramValues.hobby[0] }<br>
    hobby的第二个值是：${ paramValues.hobby[1] }<br>
    <hr>
    ${header}
    <hr>
    header中accept-language的语言有：${header['accept-language']}<br>
    header中connection的状态是：${header['connection']}<br>
    <hr>
    header中accept-language的语言是：${ headerValues['accept-language'][0]}
```

``` txt
username的值是：param
password的值是：123456
---------------------
hobby的第一个值是：java
hobby的第二个值是：jsCrript
---------------------------------------------
{accept-language=zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2, cookie=JSESSIONID=535DA2BB1D0731E0211D5689D018BC67, host=127.0.0.1:8080, upgrade-insecure-requests=1, connection=keep-alive, cache-control=max-age=0, accept-encoding=gzip, deflate, user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:82.0) Gecko/20100101 Firefox/82.0, accept=text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8} 
------------------------------------------------------------------------------------------------------
header中accept-language的语言有：zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2
header中connection的状态是：keep-alive
-------------------------------------------------------------------------------------------------------
header中accept-language的第一种语言是：zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2 
```

### JSTL标签库

* JSTL标签库的全称是指：JSP Standard Tag Library
* EL表达式的作用是代替jsp中的表达式脚本，而JSTL标签库主要用来代替jsp中的代码脚本，使代码更加简洁

#### JSTL标签库的使用步骤

* 导入jar包

  * taglibs-standard-impl-1.2.1.jar
  * taglibs-standard-spec-1.2.1.jar

* 使用taglib指令引入标签库

  ```jsp
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  ```

#### core核心库的使用

1. **set标签的作用**

   * **可以向域中添加数据**

   ```jsp
   <%--  set标签
               scopee属性可以设置域对象
               var属性设置key值
               value设置value值
               --%>
       pageContext之前的值：${pageScope.key}<br>
       <c:set scope="page" var="key" value="value"/>
       pageContext之后的值：${pageScope.key}
   ```

2. **if标签库的使用**

   ```jsp
    <%--   if标签
               用来判断表达式
               test属性表示判断的条件(利用EL表达式表达)
         --%>
   
       <c:if test="${ 12==12 }">
           <h1>12=12</h1>
       </c:if>
   ```

   

3. **<c:choose>**
    **           **<c:when>**
                   <c:otherwise>标签的使用**

```jsp
	<%--   <c:choose>
            <c:when>
                <c:otherwise>
             和switch语句很相似，不过switch语句中只有break才能让循环结束，二<c:choose>标签不用，当一个条件成立后就跳出循环

      --%>

    <%
        request.setAttribute("key",192);
    %>
    <hr>
    <c:choose>
        <c:when test="${ requestScope.key >190 }">
            <h1>大于190</h1>
        </c:when>
        <c:when test="${ requestScope.key >180 }">
            <h1>大于180</h1>
        </c:when>
        <c:when test="${ requestScope.key >170 }">
            <h1>大于170</h1>
        </c:when>
        <C:otherwise>
            <h1>小于170</h1>
        </C:otherwise>
    </c:choose>>
    
    </c:when>
</c:choose>
```

4. **forEach标签的使用**

```jsp
<%-- 遍历从一到十 --%>
    <%--  begin表示从什么开始遍历，end表示什么时候结束，var表示遍历的变量  --%>
    <s:forEach begin="1" end="10" var="i">
        ${i}<br>
    </s:forEach>

    <hr>
    <%--  遍历object【】数组  --%>

    <%
        request.setAttribute("arr",new String[]{"12345678","789456132","10000000"});
    %>

    <%--  items表示数据源   var表示遍历的变量  --%>
    <c:forEach items="${ requestScope.arr }" var="i">
        ${ i }<br>
    </c:forEach>

    <%--  遍历map集合  --%>
    <%
        Map<String,Object> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        map.put("key3","value3");
        map.put("key4","value4");
        request.setAttribute("map",map);
    %>
    <hr>
    <%--  items表示数据源   var表示遍历的变量  --%>

    <c:forEach items="${requestScope.map}" var="entry">
        ${entry.key} = ${entry.value}<br>
    </c:forEach>

    <hr>
    <%--  遍历list数组的值 --%>
    <%
        List<Student> studentList = new ArrayList<>();
        for(int i=1; i<=10; i++){
            studentList.add(new Student(i,i+18,"name"+i,"phone"+i));
        }

        request.setAttribute("stuList",studentList);
    %>

    <table border="1" width="500" bgcolor="#fff8dc" cellspacing="0">

        <td>编号</td>
        <td>年龄</td>
        <td>姓名</td>
        <td>电话</td>
    <c:forEach items="${ requestScope.stuList }" var="list">
        <tr>
            <td>${list.id}</td>
            <td>${list.age}</td>
            <td>${list.name}</td>
            <td>${list.phone}</td>
        </tr>
    </c:forEach>
    </table>
```

输出：

------

​			1
​            2
​            3
​            4
​            5
​            6
​            7
​            8
​            9
​            10

------

​            12345678
​            789456132
​            10000000

------

​            key1 = value1
​            key2 = value2
​            key3 = value3
​            key4 = value4

------

| 编号 | 年龄 | 姓名   | 电话    |
| ---- | ---- | ------ | ------- |
| 1    | 19   | name1  | phone1  |
| 2    | 20   | name2  | phone2  |
| 3    | 21   | name3  | phone3  |
| 4    | 22   | name4  | phone4  |
| 5    | 23   | name5  | phone5  |
| 6    | 24   | name6  | phone6  |
| 7    | 25   | name7  | phone7  |
| 8    | 26   | name8  | phone8  |
| 9    | 27   | name9  | phone9  |
| 10   | 28   | name10 | phone10 |

#### forEach标签的组合使用

```jsp
<table border="1" width="1000"  bgcolor="#fff8dc" cellspacing="0">

        <td>编号</td>
        <td>年龄</td>
        <td>姓名</td>
        <td>电话</td>
        <td>当前对象</td>
        <td>遍历步长</td>
        <td>是否第一</td>
        <td>是否最后</td>
        <td>获取第一</td>
        <td>获取最后</td>
        <td>获取下标</td>
    <%--  begin表示从下标为0开始遍历  end表示从下标9结束  varstatus表示当前对象    --%>
    <c:forEach  begin="0" end="9" step="1" varStatus="Status"   items="${ requestScope.stuList }" var="list">
        <tr>
            <td>${list.id}</td>
            <td>${list.age}</td>
            <td>${list.name}</td>
            <td>${list.phone}</td>
            <td>${ Status.current }</td>
            <td>${ Status.step }</td>
            <td>${ Status.first }</td>
            <td>${ Status.last }</td>
            <td>${ Status.begin }</td>
            <td>${ Status.end }</td>
            <td>${ Status.index }</td>

        </tr>
    </c:forEach>
```

结果：

| 编号 | 年龄 | 姓名   | 电话    | 当前对象(status)                                       | 遍历步长(step) | 是否第一(first) | 是否最后(last) | 获取第一(begin) | 获取最后(end) | 获取下标(index) |
| ---- | ---- | ------ | ------- | ------------------------------------------------------ | -------------- | --------------- | -------------- | --------------- | ------------- | --------------- |
| 1    | 19   | name1  | phone1  | Student{id=1, age=19, name='name1', phone='phone1'}    | 1              | true            | false          | 0               | 9             | 0               |
| 2    | 20   | name2  | phone2  | Student{id=2, age=20, name='name2', phone='phone2'}    | 1              | false           | false          | 0               | 9             | 1               |
| 3    | 21   | name3  | phone3  | Student{id=3, age=21, name='name3', phone='phone3'}    | 1              | false           | false          | 0               | 9             | 2               |
| 4    | 22   | name4  | phone4  | Student{id=4, age=22, name='name4', phone='phone4'}    | 1              | false           | false          | 0               | 9             | 3               |
| 5    | 23   | name5  | phone5  | Student{id=5, age=23, name='name5', phone='phone5'}    | 1              | false           | false          | 0               | 9             | 4               |
| 6    | 24   | name6  | phone6  | Student{id=6, age=24, name='name6', phone='phone6'}    | 1              | false           | false          | 0               | 9             | 5               |
| 7    | 25   | name7  | phone7  | Student{id=7, age=25, name='name7', phone='phone7'}    | 1              | false           | false          | 0               | 9             | 6               |
| 8    | 26   | name8  | phone8  | Student{id=8, age=26, name='name8', phone='phone8'}    | 1              | false           | false          | 0               | 9             | 7               |
| 9    | 27   | name9  | phone9  | Student{id=9, age=27, name='name9', phone='phone9'}    | 1              | false           | false          | 0               | 9             | 8               |
| 10   | 28   | name10 | phone10 | Student{id=10, age=28, name='name10', phone='phone10'} | 1              | false           | true           | 0               | 9             | 9               |

### 文件的上传

* ```xml
  <form method="post" enctype="multipart/form-data" ></form>
  ```

* form标签必须设置属性--**method="post"**

* form标签必须设置属性--**enctype="multipart/from-data"**

* input标签必须设置属性--**type="file"**

* 然后编写servlet程序代码

![](F:\javaWeb\资料\截图\25.png)

#### commons-fileupload.jar 常用ApI说明

* 导入两个jar包

  * **commons-io-1.4.jar**
  * **commons-fileupload-1.2.1.jar**

* 常用类

  * **ServletFileUpLoad**类，用于解析上传的数据

  * **FileItem**类表示每一个表单项的数据

  * 常用方法：

    ```java
    	
    	//判断是否是以多段的型式进行上传数据
    	Boolean  ServletFileUpLoad.isMultiPartContent(HttpServletRequest  request)  
            
        //获取每一个表单项
    	public list<FileItem> parseRequest(HttpServletRequest request)
            
        //判断是普通表单项，还是文件表单项，true代表普通，false代表文件表单项
        boolean FileItem.isFormFiled()
            
        //获取表单项的值
        String FileItem.getString()
            
        //获取表单项的name属性值
        String FileItem,getFiledName()
            
        //获取上传的文件名
        String FileItem.getName()
             
        //将上传的文件写入到对应的路径中
        void FlieItem.write(file)
    ```

示例：

```java
<form  action="http://localhost:8080/06_EL_JSTL/fileLoadServlet" method="post" enctype="multipart/form-data" >
        用户名：<input type="text" name="username" /><br>
        上传文件：<input type="file" name="photo" ><br>
        <input type="submit">
    </form>
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //post首先需要设置字符集为UTF-8，避免中文乱码
        request.setCharacterEncoding("UTF-8");
        //判断是否是以多段的形式上传数据
        if(ServletFileUpload.isMultipartContent(request)){
            //创建FileIteFactory工厂实现类,FileIteFactory是一个接口
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            //创建用于解析上传数据的工具类ServletFileUpload对象
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            //调用parseRequest()方法解析数据
            try {
                //获得了表单的数据集合
                List<FileItem> list = servletFileUpload.parseRequest(request);
                //循环判断每一个表单
                for(FileItem fileItem : list){
                    //判断是普通表单还是文件表单
                    if(fileItem.isFormField()){
                        //普通表单
                        //获取表单的name属性值
                        System.out.println("表单的name属性值：" + fileItem.getFieldName());
                        //获取表单的内容,UTF-8解决中文乱码问题
                        System.out.println("表单的内容：" + fileItem.getString("UTF-8"));

                    } else{
                        //文件表单
                        //获取上传的文件名
                        System.out.println("上传的文件名：" + fileItem.getName());
                        //将文件写入磁盘中
                        fileItem.write(new File("f://" + fileItem.getName()));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
```

### 文件的下载

```java 
public class DownLoadServlet extends HttpServlet{
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //首先获取文件名
        String downLoadFile = "7.jpg";
        //然后读取文件（利用ServletContext对象可以读取文件）
        InputStream resourceAsStream = getServletContext().getResourceAsStream("/img/" + downLoadFile);
        //然后需要获取数据类型，还是利用ServletContext对象获取
        String mimeType = getServletContext().getMimeType("/img/" + downLoadFile);
        //可以输出一下文件的类型
        System.out.println(mimeType);
        //设置文件类型
        response.setContentType(mimeType);
        //告诉客户端此文件是用来下载的，设置响应头
        //content-Disposition响应头，表示收到的数据怎么处理
        //attachment表示附件，用于下载使用
        //filename=文件名，设置下载的文件名
        response.serHeader("content-Disposition","attachment; filename= " + downLoadFile);
        /*
          如果这里的文件名要设置成中文的话，必须经过处理不然会乱码，用java.net.URLEncoder类处理
          responser.setHeader("contentType-Disposition","attachment; filename=" + URLEncoder.encode("中																							国.jpg","UTF-8"));
        */			
        //将文件传给客户端，首先需要创建输出流
        ServletOutputStream outputStream = response.getOuputStream();
        //利用org.apache.commons.io.IOUtils类的copy方法将文件内容赋值给输出流,直接响应给了客户端
        IoUtils.copy(resourceAsStream,outputStream);
    }
    
}
```



## 书城项目第三阶段

### 将html页面全部替换成jsp页面

* 先将jsp的page指令引用到html页面

* ```java
  <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  ```

* 然后再替换文件名后缀为jsp

* 然后更改页面内容的某些标签的跳转地址后缀为jsp，如下图

* **快捷键：Ctrl+Shift+R**

![](F:\javaWeb\资料\截图\26.png)

### 抽取所有的jsp公共内容页面

* 将公共的页面内容全部用静态包含引用，减少代码的冗余

* base标签必须动态获取

  ```java
  String base = requset.getSheme + "://" + request.getServerName + ":" + requset.getServerPort + "/" + request.getContextPath + "/";
  ```



### 表单的失败回显

* 在用户注册或者登陆失败的时候表单项需要回显

```java
//在登陆失败时
//提示错误信息
request.setAttribute("msg","用户名或者密码错误！！");
//保存用户名，用户名在上方的时候已经获取
requset.setSttribute("username",username);


//在注册失败的时候
//提示错误信息，验证码错误的时候
requset.setAttribute("msg","验证码错误！！")
//保存用户名和email
requset.setAttribute("username",uesrname);
requset.setAttribute("email",email);
//用户名存在的时候
requset.serAttribute("msg","用户名已存在")
//保存用户名和email
requset.setAttribute("username",uesrname);
requset.setAttribute("email",email);


```

```jsp
在jsp页面中
注册页面
<span class="errorMsg">
	${ requestScope.msg==null?"":requestScope.msg }
</span>

<input class="itxt" type="text" placeholder="请输入用户名"
	autocomplete="off" tabindex="1" name="username" id="username"
	 value="${ requestScope.username==null?"":requestScope.username }"/>

<input class="itxt" type="text" placeholder="请输入用户名"
	autocomplete="off" tabindex="1" name="username" id="username"
 	value="${ requestScope.username==null?"":requestScope.username }"/>

登录中：
<span class="errorMsg">
	${ requestScope.msg==null?"请输入用户名和密码":requestScope.msg }
</span>

<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username"
	value="${ requestScope.username==null?"":requestScope.username }"/>
```

​	

### 合并loginServlet和registerServlet程序

* 两个程序一个是登陆，一个是注册，只需要将发送过来的请求判断是哪个请求，然后执行对应的操作
* 需要用到隐藏标签

```jsp
<%@ content-Type="text/html; charset=UTF-8" language="java" %>
<%--在表单项中加入隐藏标签--%>
<%--name属性值都设置为action，value属性值设置为相应的请求名称--%>
登陆：
<input type="hidden" name="action" value="login"/>
注册：
<input type="hidden" name="action" value="regist"/>
```

```java


	UserService userService = new UserService();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取数据
        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());
        //验证是否有此用户，有就跳转到success-login，没有就跳到登录页面
        if (userService.loginUser(user.getUsername(), user.getPassword()) == null) {
            //错误回显
            request.setAttribute("msg", "用户或密码错误!!");
            request.setAttribute("username", user.getUsername());
            request.getRequestDispatcher("/pages/user/login.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/pages/user/login_success.jsp").forward(request, response);
        }
    }

    protected void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");

        User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());
        System.out.println(user);

        //验证验证码是否正确,正确的话继续下面的操作，不正确就返回新注册页面
        if ("abcde".equals(code)) {
            //验证用户名是否存在
            if (userService.existUser(user.getUsername())) {
                //不存在，保存用户信息，进入注册成功页面
                userService.registUser(user);
                request.getRequestDispatcher("/pages/user/regist_success.jsp").forward(request, response);
            } else {

                //存在，返回注册页面
//                System.out.println("用户名已存在");
                //提示错误信息
                request.setAttribute("msg", "用户名已存在");
                //表单项的回显
                request.setAttribute("username", user.getUsername());
                request.setAttribute("email", user.getEmail());
                request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
            }
        } else {
//            System.out.println("验证码错误");
            //提示错误信息
            request.setAttribute("msg", "验证码错误");
            //表单项的回显
            request.setAttribute("username", user.getUsername());
            request.setAttribute("email", user.getEmail());
            request.getRequestDispatcher("/pages/user/regist.jsp").forward(request, response);
        }
    }
	public void doPost(HttpServletRequest request, HttpServletResponse response){
        //在doPost程序中判断是何请求
        String action = requset.getParameter("action");
        if("login".equals(action)){
            login(request,response);
        } else if("regist".equals(action)){
            regist(request,response);
        }
    }
```

### 程序优化

* 反射的使用

* BaseServlet类的创建

  * 创建BaseServlet类继承HttpServlet类，执行doPost方法，然子类继承BaseServlet，子类就不需要写doPost方法，减少代码量

  ```java
  public class BaseServlet extends HttpServlet {
  
      protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String action = request.getParameter("action");
  
          try {
              //通过反射机制获取当前需要的方法
              Method declaredMethod = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
              System.out.println(declaredMethod);
              //调用方法，传入参数
              declaredMethod.invoke(this, request, response);
  
          } catch (Exception e) {
              e.printStackTrace();
          }
      }
  
  }
  ```

  

* BeanUtils工具类的使用

* 需要导入jar包

  * commons-beanutils-1.8.0.jar
  * commons-logging-1.1.1.jar

```java
/**
 * @program: javawebExecise
 * @description:封装表单数据到相关的类中
 * @author: Mr.Yu
 * @create: 2020-11-16 21:49
 **/
public class WebUtils {

    public static <T> T copyParamToBean(Map map, T bean){
        /**
        * @Description: 封装表单数据到相关的类中
        * @Param: [map：这里可以传入request，但是为了可以让Dao层和Service层也可使用，传进map，增加了代码的耦合性, bean：具体的实体类]
        * @return: T
        * @Author: Mr.Yu
        * @Date: 2020/11/16
        */
        try {
            BeanUtils.populate(bean, map);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;
    }

}
//获取用户的全部参数，不需要再一一获取，让代码更加优雅
User user = WebUtils.copyParamToBean(request.getParameterMap(), new User());
```

## Cookie

### 什么是cookie

* cookie是servlet发送到web浏览器的少量信息，这些信息有浏览器保存，然后发送回服务器，cookie的值可以唯一标示客户端，因此cookie常用于会话管理
* cookie是服务器通知客户端保存键值对的一种技术
* 客户端有了cookie后，每次都会以请求头的形式发送给服务器
* 每个cookie的大小不能超过4kb

### 如何创建cookie

```java
public void create(HttpServletRequest request, HttpServletResponse response) {
    //创建cookie
    Cookie cookie = new Cookie("key1","value");
    //将cookie响应给客户端
    response.addCookie(cookie);
    //提示
    response.getWriter().write("cookie创建成功！！");
}
```

### 服务器如何获取cookie

```java
public void getCookie(HttpServletRequest request, HttpServletResponse response){
    Cookie[] cookies = request.getCookies();
    
    //遍历cookie，进行打印
    for(Cookie cookie : cookies){
        System.out.println("cookie[" + cookie.getName() + "=" +cookie.getValue() + "]")
    }
    
    //获取特定的cookie
    Cookie cookie = CookieUtils.findCookies("key",cookies);
}

public class CookieUtils {

    // @description:获取指定的cookie
    public static Cookie findCookie(String key, Cookie[] cookies){

        if(key == null || cookies == null || cookies.length == 0){
            return null;
        }
        for(Cookie cookie : cookies){
            if(key.equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }

}

```

### cookie的修改

```java 
方案一：
public void updateCookie1(HttpServletRequest request, HttpServletResponse response){
 	//首先创建一个同名(key值相同)的cookie对象，然后在构造器中直接修改
    Cookie cookie = new Cookie("key1","newValue1");
    //发给客户端
    response.addCookie(cookie);
}

方案二：
public void updateCookie(HttpServletRequest request, HttpServletResponse response){
    
        Cookie[] cookies = request.getCookies();
        //获取想要修改的cookie对象
        Cookie cookie = CookieUtils.findCookie("key2",cookies);
        //利用setValue方法改变cookie
        cookie.setValue("newValue2");
        //发送给客户端
        response.addCookie(cookie);
}
```

### 浏览器查看cookie

* 谷歌浏览器

![](F:\javaWeb\资料\截图\27.png)

* 火狐浏览器
  *  打开控制台之后查看存储，左键可以进行删除操作

### cookie的存活时间

* ###### **public int getMaxAge() 返回以秒为单位指定的 cookie 的最大生存时间**

* ###### public void **setMaxAge**(int expiry) 设置 cookie  的最大生存时间，以秒为单位。 

* 默认情况下，秒数是-1，表示cookie将保存到浏览器关闭为止

* 当秒数为0时，cookie会被删除

* 当秒数为正数时，表示cookie在该正值秒后就会被销毁

```java
protected void lifeDefault(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = CookieUtils.findCookie("key1",req.getCookies());
        if(cookie != null){
            //浏览器关闭时就会消亡
            cookie.setMaxAge(-1);
            resp.addCookie(cookie);
        }
    }

    protected void lifeDead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = CookieUtils.findCookie("key2",req.getCookies());
        if(cookie != null){
            //cookie直接被删除
            cookie.setMaxAge(0);
            resp.addCookie(cookie);
        }
    }

    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = CookieUtils.findCookie("key3",req.getCookies());
        if(cookie != null){
            //cookie将会存活3600秒
            cookie.setMaxAge(60*60);
            resp.addCookie(cookie);
        }
    }
```



### cookie的path属性

* cookie的path属性可以过滤掉路径不匹配的cookie
* cookie的path属性必须包含在被访问的路径中，才能获得cookie

### 免用户名登录

![](F:\javaWeb\资料\截图\28.png)

```jsp
<form action="http://localhost:8080/07_Cookie_Session/loginServlet" method="post">
        用户名：<input type="text" name="username" value="${cookie.username.value}" />
        密码：<input type="password" name="password" />
        <input type="submit" name="sub">
    </form>

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if("dajiao123".equals(username) && "123456".equals(password)){
            //保存用户名到cookie中
            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(60*60*24*7);//一个星期内有效
            //发送给客户端
            response.addCookie(cookie);
            System.out.println("登陆成功");
         } else {
            System.out.println("登陆失败");
        }
    }
}

登录成功后服务器的请求头：
Cookie: JSESSIONID=2491878C0B764F3DD47DADAC4DBA9047; username=dajiao123
```

## Session

### 什么是session

* session就是一个接口(HttpSession)
* session就是会话，它是用来维护客户端和服务器之间关联的技术
* 每个客户端都有自己的一个session会话
* session会话中，我们经常用来保存用户登陆之后的信息

### session的创建和获取

* **request.getSession()，**
  * 第一次执行此方法时，会创建session会话
  * 之后执行此方法时，就是获取session会话
* **ISNew()**--- 此方法用以判断session是否是刚创建出来的
  * true代表是刚创建的
  * false代表获取之前创建的
* 每个会话都有自己的唯一的一个ID值--**getId()**--可以获取这个id

### session的存取数据

* setAttribute()
* getAttribute()



### session的生命周期

* session的默认超时时长是30分钟

* setMaxInactiveInterVal()，方法可以单独设置一个session的超时时长,单位是秒

* 在配置文件中可以设置全部session的时长

  * ```xml
        <session-config>
            <!--    设置session的超时时长为20分钟，单位是分钟    -->
            <session-timeout>20</session-timeout>
        </session-config>
    ```

* getMaxInactiveInterval()可以获取session的超时时长

* invalidate()方法可以设置session立即无效

代码示例：

```java
public class SessionServlet extends BaseServlet {


    protected void lifeDefault(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //获取默认的超时时间
        int maxInactiveInterval = session.getMaxInactiveInterval();
        resp.getWriter().write("session的默认超时时长是：" + maxInactiveInterval);
    }

    protected void setLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //获取默认的超时时间
        int maxInactiveInterval = session.getMaxInactiveInterval();
        resp.getWriter().write("session的设置超时时长是：" + maxInactiveInterval);
    }

    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //设置session的超时时间
        session.setMaxInactiveInterval(3);
    }

    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        //设置session马上无效
        session.invalidate();
        resp.getWriter().write("session already dead!!");
    }



    protected void createSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //创建session
        HttpSession session = request.getSession();
        //判断是否是刚创建的session
        boolean aNew = session.isNew();
        //获取session的id值
        String id = session.getId();
        //打印给客户端
        response.getWriter().write("session创建完毕，session的id是：<br>");
        response.getWriter().write(id + "<br>");
        response.getWriter().write("session是否是新创建的：" + aNew);
    }

    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1","value1");
        resp.getWriter().write("session存取数据完毕");
    }

    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object key1 = req.getSession().getAttribute("key1");
        resp.getWriter().write("session获取的数据：" + key1);
    }
}

```

### 浏览器和session之间的内幕

![](F:\javaWeb\资料\截图\29.png)

## Filter过滤器

* filter过滤器是javaWeb三大组件之一
* filter过滤器是javaEE的规范，也就是接口
* filter过滤器的作用是：拦截请求，过滤响应
* 拦截请求的常见应用场景有：
  * 权限检查
  * 日记操作
  * 事务管理

### Filter过滤器初始用

* 首先创建web工程，在web目录下建立一个admin目录，在admin下创建jsp，html，图片文件
* 需求：不能让用户直接访问admin目录，需要登陆之后才允许访问

```jsp
<body>
    登录页面
    <form action="/10_filter/loginServlet" method="get">
        用户名：<input type="text" name="username"/><br>
        用户密码：<input type="password" name="password"/><br>
        <input type="submit">
    </form>
</body>

//处理登陆业务
public class LoginServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("laoyu".equals(username) && "123456".equals(password)){
            request.getSession().setAttribute("username",username);
            response.getWriter().write("登陆成功！");
        } else {
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
配置loginServler的地址...


```

* 然后创建filter拦截程序s

```java
public class FilterTest implements java.Servlet.Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //主要重写doFilter方法
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        Object username = session.getAttribute("username");

        //如果用户名为空，就跳转到登录页面
        if (username == null){
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
        } else {
            //就跳转到下一个过滤器，如果没有下一个过滤器就跳转到指定的资源路径
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}

配置路径
    <!--这个表示的是filter程序的拦截路径,当用户访问/admin下的资源时，会跳转到filter拦截程序进行处理-->
    <filter>
        <filter-name>FilterTest</filter-name>
        <filter-class>com.dajiao.web.FilterTest</filter-class>
    </filter>
    <filter-mapping>
        <filter-name>FilterTest</filter-name>
        <!--    /  表示到idea的web目录
                *  表示action目录下的全部文件
         -->
        <url-pattern>/admin/*</url-pattern>
    </filter-mapping>
    
    
```

### Filter的生命周期

* 执行构造器方法
* 执行初始化方法
* 执行doFilter拦截方法
* 执行销毁方法

### FilterConfig类的介绍

* 此类的作用是获取Filter程序的配置文件的内容

1. 可以获取Filter-name的内容
2. 可以获取init-param初始化参数
3. 可以获取ServletContext对象

### 多个Filter过滤器执行时候的细节

![](31.png)

示例：

```java
public class Filter1 implements Filter{
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
            System.out.println("filter1的前置代码");
        	System.out.println("线程名：" + Thread.currentThread().getName());
        	//没有这句代码程序将直接返回客户端
            chain.doFilter(req,resp);
            System.out.println("filter1的后置代码");
        }
}

//两个filter程序都拦截的是test.jsp页面

public class Filter2 implements Filter{
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("filter2的前置代码");
        System.out.println("线程名：" + Thread.currentThread().getName());
        chain.doFilter(req, resp);
        System.out.println("filter2的后置代码");
    }
}

<body>
这是test.jsp页面
    <%
   		System.out.println("线程名：" + Thread.currentThread().getName());
        System.out.println("这是test.jsp");
    %>
</body>
</html>
        
运行结果：
    filter1的前置代码
    线程名：http-apr-8080-exec-15
    filter2的前置代码
    线程名：http-apr-8080-exec-15
    线程名：http-apr-8080-exec-15
    这是test.jsp
    filter2的后置代码
    filter1的后置代码
```

### Filter拦截路径的三种配置方式

* 精确匹配
  * /a.jsp  直接匹配到对应的资源文件http://ip:port/工程路径/a.jsp就可以拦截
* 目录匹配
  * admin/* 	匹配到admin目录  请求地址http://ip:port/工程路径/admin/某某文件  就可以拦截
* 后缀名匹配 
  * *.jsp  请求地址结尾是.jsp就可以拦截
  * *.html  请求地址结尾是.html就可以拦截
  * *.acs  请求地址结尾是.acs就可以拦截

* **Filter过滤器不会管资源是否存在，只关心地址是否匹配！！**

## JSON

* JSON是一种轻量级的数据交换格式，易与人的阅读和编写，同时以易于机器解析和生成
* 轻量级是跟xml作比较
* 数据交换指的是客户端和服务器之间业务数据的传递格式

### json在JavaScript中的使用

* json是由键值对组成的，并且由花括号包围，每个键值对由引号引起来，键和值之间用冒号隔开，多对键值对之间用逗号隔开

```jsp
Example:
	// json的定义

			var jsonObj = {
				"key1":1,
				"key2":"asd",
				"key3":true,
				"key4":[123,"asd",false],
				"key5":{
					"key5_1":123,
					"key5_2":"key5_2_value"
				},
				"key6":[{
					"key6_11":456,
					"key6_12":"qwe"
				},{
					"key6_21":789,
					"key6_22":"acv"
				}]
			}
			// json的访问
			// alert(jsonObj.key1);
			// alert(jsonObj.key2);
			// alert(jsonObj.key3);
			// for (var i=0; i<jsonObj.key4.length; i++){
			//
			// 	alert(jsonObj.key4[i]);
			// }
			// alert(jsonObj.key5.key5_1);
			// alert(jsonObj.key5.key5_2);
			// alert(jsonObj.key6[0].key6_11);

			// json对象转字符串
			var jsonString = JSON.stringify(jsonObj);
			alert(jsonString);

			// json字符串转json对象
			var jsonObj2 = JSON.parse(jsonString);
			alert(jsonObj2);
```



### javaBean,Map.List和json的相互转换

* 导包：**gson-2.2.4.jar**

```java
Example:
public class TestJson {

    //Json和java互相逆转
    @Test
    public void TestBean(){
        Student student = new Student(1, "广哥大英雄");
        //创建Gson
        Gson gson = new Gson();
        //将javaBean转换成json字符串
        String s = gson.toJson(student);
        System.out.println(s);
        //将json字符串转换成JavaBean
        Student student1 = gson.fromJson(s, Student.class);
        System.out.println(student1);
    }

    //Json和list互转
    @Test
    public void TestList(){

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1,"广哥大英雄"));
        students.add(new Student(2,"小敏小仙女之无敌大长腿"));
        //创建Gson对象
        Gson gson = new Gson();
        //将list装换成json字符串
        String json = gson.toJson(students);
        System.out.println(json);
        //创建匿名类对象实例，将json字符串装换成list
        List<Student> list = gson.fromJson(json, new TypeToken<ArrayList<Student>>() {
        }.getType());
        System.out.println(list);
    }

    @Test
    public void TestMap(){

        HashMap<Integer, Student> map = new HashMap<>();
        map.put(1,new Student(1,"广哥大英雄"));
        map.put(2,new Student(2,"小敏小仙女之无敌大长腿"));
        //创建Gson对象
        Gson gson = new Gson();
        //将map装换成json字符串
        String json = gson.toJson(map);
        System.out.println(json);
        //创建匿名类对象实例，将json字符串装换成map
        HashMap JsonMap = gson.fromJson(json, new TypeToken<HashMap<Integer, Student>>() {
        }.getType());
        System.out.println(JsonMap);

    }
}
```



## AJAX请求

* ajax是一种浏览器通过js异步发起请求，局部更新页面的技术

* 所谓异步就是ajax执行ajax的请求，不会干扰到ajax之后的代码
* 局部页面更新就是页面网址栏不会改变，而页面的内容发生了一些改变

```jsp
example:

public class AjaxServlet extends BaseServlet {

    protected void javaScriptAjax(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("ajax请求！！");
        Student student = new Student(1, "广哥大英雄");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Gson gson = new Gson();
        String toJson = gson.toJson(student);
        resp.getWriter().write(toJson);
    }
}

function ajaxRequest() {
// 				1、我们首先要创建XMLHttpRequest 
				var xmlHttpRequest = new XMLHttpRequest();
				// 2、调用open方法设置请求参数
				xmlHttpRequest.open("GET","http://localhost:8080/11_JSON_AJAX_i18n/ajaxServlet?action=javaScriptAjax",true);

// 				4、在send方法前绑定onreadystatechange事件，处理请求完成后的操作。
				xmlHttpRequest.onreadystatechange = function (){
					if (xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200){
						document.getElementById("div01").innerHTML = xmlHttpRequest.responseText;
					}
				}
				//3、调用send方法发送请求
				xmlHttpRequest.send();
				alert("在ajax之后")
			}
		</script>
```

### jQuery的ajax请求

```java
ajax请求：
$.ajax({
    url:请求地址
    data:请求参数
    type:请求方式
    success:请求成功，响应的回调函数
    dataType:响应的数据（text,xml,json）
})
    
$.get(url,data,success,dataType)
$.post(url,data,success,dataType)
$.getJson(url,data,success)
    
example:
$(function(){
				// ajax请求
				$("#ajaxBtn").click(function(){

					$.ajax({
						url:"http://localhost:8080/11_JSON_AJAX_i18n/ajaxServlet",
						data:"action=jqueryAjax",
						type:"GET",
						success:function (data){
							// var jsonObj = JSON.parse(data);
							$("#ajax_div").html("id=" + data.id + ",name=" + data.name);
						},
						dataType:"json"
					})
				});

				// ajax--get请求
				$("#getBtn").click(function(){
					$.get("http://localhost:8080/11_JSON_AJAX_i18n/ajaxServlet", "action=jQueryGetAjax", function (data){
						var jsonObj = JSON.parse(data);
							$("#ajax_div").html("get-id=" + jsonObj.id + ",name=" + jsonObj.name);
						}, "text")
				});
				
				// ajax--post请求
				$("#postBtn").click(function(){
					// post请求
					$.post("http://localhost:8080/11_JSON_AJAX_i18n/ajaxServlet", "action=jQueryPostAjax",
						function (data){
							var jsonObj = JSON.parse(data);
							$("#ajax_div").html("post-id=" + jsonObj.id + ",name=" + jsonObj.name);
						}, "text")
				});

				// ajax--getJson请求
				$("#getJSONBtn").click(function(){
					$.getJSON("httP://localhost:8080/11_JSON_AJAX_i18n/ajaxServlet","action=ajaxGetJSon",function (data){
						$("#ajax_div").html("JSon-id=" + data.id + ",name=" + data.name);
					});
				});

				// ajax请求
				$("#submit").click(function(){
					// 把参数序列化
					// alert("serialize()");
					// alert( $("#form01").serialize() );
					$.getJSON("httP://localhost:8080/11_JSON_AJAX_i18n/ajaxServlet","action=ajaxSerialize&" + $("#form01").serialize(),function (data){
						$("#ajax_div").html("JSon-id=" + data.id + ",name=" + data.name);
					});
				});
			});
```



## I18n国际化

* Locale:获取时区属性
* properties配置文件：配置显示参数与其相应的语言
* ResourceBundle.getBundle()，获取ResourceBundle类，可以设置locale和其对应的properties配置文件

```java
example:
@Test
    public void test2(){

        Locale locale = Locale.CHINA;
        //通过指定的basename和locale信息，获取相应的properties配置文件信息
        ResourceBundle bundle = ResourceBundle.getBundle("i18n",locale);

        System.out.println("username="+bundle.getString("username"));
        System.out.println("password="+bundle.getString("password"));
        System.out.println("sex"+bundle.getString("sex"));
        System.out.println("age="+bundle.getString("age"));

    }

i18n_zh_CN.properties:
username=用户名
password=用户密码
sex=性别
age=年龄
regist=注册
email=邮箱
boy=男
girl=女
    
i18n_en_US.properties
username=用户名
password=用户密码
sex=性别
age=年龄
regist=注册
email=邮箱
boy=男
girl=女
    
console
    username=用户名
    password=用户密码
    sex性别
    age=年龄

```

### 使用JSTL标签库来国际化页面

* 导包：
  * taglibs-standard-impl-1.2.1.jar
  * taglibs-standard-spec-1.2.1.jar
* 在jsp页面中引入fmt文件
  * <%@ taglibs prefix="fmt" uri="http://java,sun.com/jstl/fmt_rt" %>

```jsp
<fmt:setLocale value="locale"/>
<fmt:setBundle basename"i18n"/>
<fmt:message key="username/password" />

example:
<fmt:setLocale value="${param.locale}"/>
	//读取配置文件
	<fmt:setBundle basename="i18n"/>

					//设置时区信息
	<a href="i18n_fmt.jsp?locale=zh_CN">中文</a>|
	<a href="i18n_fmt.jsp?locale=en_US">english</a>
	<center>
        //设置页面展示信息
		<h1><fmt:message key="regist"/></h1>
		<table>
		<form>
			<tr>
				<td><fmt:message key="username"/></td>
				<td><input name="username" type="text" /></td>
			</tr>
			<tr>
				<td><fmt:message key="password"/></td>
				<td><input type="password" /></td>
			</tr>
			<tr>
				<td><fmt:message key="sex"/></td>
				<td><input type="radio" /><fmt:message key="boy"/><input type="radio" /><fmt:message key="girl"/></td>
			</tr>
			<tr>
				<td><fmt:message key="email"/></td>
				<td><input type="text" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="reset" value="重置" />&nbsp;&nbsp;
				<input type="submit" value="提交" /></td>
			</tr>
			</form>
		</table>
```

