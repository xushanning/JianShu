//着色器版本，3.0的版本要写，2.0版本可不写
#version 300 es
//输入属性的数组（一个名为vPosition的4分量向量）
//layout(location=0)表示这个变量的位置是顶点属性0
layout (location=0) in vec4 vPosition;
void main(){
    gl_Position=vPosition;
    gl_PointSize=10.0;
}