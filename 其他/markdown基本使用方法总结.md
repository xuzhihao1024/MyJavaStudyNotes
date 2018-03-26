目录

区块元素
标题

列表

区块引用

代码区块

分隔线

段落和换行

区段元素
链接

强调

代码

图片

转义

标题 <a name="title"></a>

类Setext

This is an H1

This is an H2

  Code:

  This is an H1   
  ====
  This is an H2
  ----
备注:任何数量的=和-都可以有效果

=表示最高阶标题,-表示第二阶标题

atx形式

This is an H1

This is an H2

This is an H3

This is an H4

This is an H5

This is an H6

  Code:

  # This is an H1

  ## This is an H2

  ### This is an H3

  #### This is an H4

  ##### This is an H5

  ###### This is an H6 
也可以表示成这样 # This is an H1 # 
备注: 行首n个#表示n阶标题，n最大为6

列表

有序列表

有序列表使用数字接着一个英文句点

Bird
McHale
    Code:
    1. Bird
    2. McHale
无序列表

无序列表是使用,+,-中任意一种来表示

Red
Green
Blue
    Code:
    - Red
    + Green
    * Blue
引用

区块引用是使用类似email中用>来表示

示例

 > 简单引用1
 > 简单引用2
 > 
 > 多行引用
 >> 嵌套引用

 > ## 引用中使用Markdown语法。
 > 
 > 1.   这是第一行列表项。
 > 2.   这是第二行列表项。
 > 
 > 给出一些例子代码：
 > 
 >     return shell_exec("echo $input | $markdown_script");
效果

简单引用1
简单引用2

多行引用

嵌套引用
引用中使用Markdown语法。

这是第一行列表项。
这是第二行列表项。
给出一些例子代码：

  return shell_exec("echo $input | $markdown_script");
代码区块

建立代码区块,只需要简单地缩进4个空格或是1个制表符就可以
代码块一直持续到没有缩进的那一行(或是文件的结尾)

也可以使用` 来表示

 代码块
 使用缩进表示代码块
分隔线

一行中用三个以上的星号、减号、底线来建立一个分隔线,行内不能有其他东西,
也可以在星号或是减号中间插入空格

 ---
 - - -
 ***
 * * *
 ——————————————  
段落和换行

段落

段落是由一个或多个连续的文本行组成,
它的前后要一个以上的空行(显示上看起来像是空的)

换行

Mardown允许段落内的强迫换行(插入换行符) 
要依赖Markdown来插入<br/>标签的话,在<br/>插入处要先按入两个以上的空格然后回车

链接

支持两种形式的连接语法: 行内式和参考式 
链接字符不区分大小写

行内式

This is baidu 
baidu

  Code:
  This is [baidu](http://www.baidu.com/ "度娘")
  [baidu](https://www.baidu.com/)
参考式

This is baidu example reference-style link.

  Code:
  This is [baidu example][id] reference-style link.
  标记: [id]: https://www.baidu.com/ "度娘"
  或者: [id]: https://www.baidu.com/ '度娘' (简书不支持)
  或者 [id]: https://www.baidu.com/ (度娘)
  (简书不支持使用对文本描述使用单引号)
隐式链接标记功能

Baidu

  Code:
  [Baidu][]
  标记可以这样写: [Baidu]: http://baidu.com
参考式链接范例:

     --I get 10 times more traffic from [Google] [1] than from 
     --[Yahoo] [2] or [MSN] [3]. 
     --[1]:  http://google.com/        "Google"
     --[2]: http://search.yahoo.com/  "Yahoo Search"
     --[3]: http://search.msn.com/    "MSN Search"
     --I get 10 times more traffic from [Google][] than from
     --[Yahoo][] or [MSN][].
     --[google]: http://google.com/        "Google"
     --[yahoo]:  http://search.yahoo.com/  "Yahoo Search"
     --[msn]:    http://search.msn.com/    "MSN Search"
     (备注: 上述代码在使用时需删掉前面的--)          
自动链接

https://www.baidu.com

  示例如下: 
  <http:\\www.baidu.com>
强调

Markdown使用性星号(*)和底线(_)作为标记强调字词的符号 
两端被一个*或_包围的单词会被转换成斜体 
两端被两个*或_包围的单词会被转换成粗体 
*或_的两端不能有空白 
用什么符号就以什么符号结尾

 示例
 *斜体*
 _斜体_
 **粗体**
 __粗体__
代码

如果要标记一段行内代码,可以用反引号 ` 把它包起来 
用多个反引号来开启和结束代码区段

行内代码
段落代码 
包含`反引号
包含 `两个反引号`
<特殊符号&>

 示例:

 ``段落代码``  
 ``包含`反引号``
 ``包含 `两个反引号` `` 
 ``<特殊符号&>``
图片
Markdown使用一种和链接很相似的语法来标记图片 
允许两种样式:行内式和参考式

行内式的图片语法:

Overload 仓助
  示例
    ![Overload 仓助](http://img4.duitang.com/uploads/item/201508/19/20150819131018_vYPyR.thumb.224_0.png   ) 
    ![Overload 仓助](http://img4.duitang.com/uploads/item/201508/19/20150819131018_vYPyR.thumb.224_0.png "森林贤王") 
参考式语法:

Overload 仓助
  示例:
    -- ![Overload 仓助][xd]  
    -- [xd]:img4.duitang.com/uploads/item/201508/19/20150819131018_vYPyR.thumb.224_0.png  "森林贤王"
   (备注: 上述代码在使用时需删掉前面的--) 
转义

使用反斜杠来插入一些在语法中有其它意义的符号,如*
需要转义的字符:

\   反斜线
`   反引号
*   星号
_   底线
{}  花括号
[]  方括号
()  括弧
#   井字号
+   加号
-   减号
.   英文句点
!   惊叹号
