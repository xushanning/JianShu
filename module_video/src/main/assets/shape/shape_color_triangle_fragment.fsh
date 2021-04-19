//颜色三角形的片元着色器
//片元着色器，光栅化完了后，有多少个像素点，就会被执行多少次

//中精度
precision mediump float;

//可变的，能装四个float点的数组，用来接收颜色
//一般在vertex中修改这个值，然后在fragment中使用这个值，两个shader中的定义声明必须是一致的。~！！！！
varying vec4 aColor;

void main() {
    //gl_FragColor:片元着色器内置输出变量：当前片元的颜色
    gl_FragColor=aColor;
}
