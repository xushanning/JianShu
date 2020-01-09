## 设计的功能点
 - 低侵入性、低耦合
 - 全局的状态view：作用于全局
 - 局部的状态view：作用于局部，其他页面不起作用
 - 重试功能
 - 通过回调将状态view返给用户，不耦合任何view，全部用户自己定义
 - 适用范围：activity、fragment、view(常见布局：LinearLayout，ConstraintLayout等，常见view：RecyclerView)
 
## 注:目前只支持androidx kotlin，不支持android support和java
 - 由于不同项目loading的设计不尽相同，因此不做处理，只对success默认实现