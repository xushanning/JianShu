//着色器版本，3.0的版本要写，2.0版本可不写
#version 300 es
//声明着色器中浮点变量的默认经度
precision mediump float;
//声明一个输出变量fragColor，是一个4分量的向量
out vec4 fragColor;
void main(){
    //将颜色值(1.0, 1.0, 1.0, 1.0)输出到颜色缓冲区
    fragColor=vec4(1.0, 1.0, 1.0, 1.0);
}