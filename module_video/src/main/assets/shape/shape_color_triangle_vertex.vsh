//颜色三角形的顶点着色器

//顶点着色器不是被执行一次，而是拿到一个点的信息 vec4 后，执行一次，然后再继续拿点执行

//attribute 代表顶点属性，这个就是顶点坐标，定义一个可以装四个float点的数组,从java层传顶点数据过来
attribute vec4 vPosition;

//uniform代表全局，4*4的四维矩阵
uniform mat4 vMatrix;

//可变的，能装四个float点的数组，
//一般在vertex中修改这个值，然后在fragment中使用这个值，两个shader中的定义声明必须是一致的。~！！！！
varying vec4 aColor;

//顶点颜色，也是一个四个float点的数组，接收从java层传递过来的颜色
attribute vec4 vColor;


void main(){
    //内置变量，顶点坐标
    gl_Position=vMatrix*vPosition;

    aColor=vColor;
}
