//顶点着色器，open gl回先执行这个着色器

//attribute 修饰后，代表可以从java层传过来
//从Java层传过来的点的坐标，vec4类型是一个能装四个浮点类型的数组:float[4]
attribute vec4 vPosition;
//纹理坐标：如何贴图
attribute vec4 vCoord;

//varying表示可变
varying vec2 aCoord;

uniform mat4 vMatrix;

void main(){
    //gl_Position是内置变量，把坐标点赋值给gl_position
    gl_Position = vPosition;
    //
    aCoord=(vMatrix * vCoord).xy;
}