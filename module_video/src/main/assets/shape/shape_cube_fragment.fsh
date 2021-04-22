//正方体片元着色器

//从顶点着色器传递过来的颜色
varying vec4 aColor;
//中等精度
precision mediump float;
void main(){
    gl_FragColor=aColor;
}
