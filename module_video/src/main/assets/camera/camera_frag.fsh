//片元着色器，执行完顶点着色器后，执行片元着色器，这个着色器执行无数次

#extension GL_OES_EGL_image_external : require
//由顶点着色器传递过来，坐标点
varying vec2 aCoord;

//SurfaceTexture比较特殊
//float数据是什么精度的
precision mediump float;


//图片采样器
uniform samplerExternalOES  vTexture;

void main(){
    //从一张图片中采样一个点，aCoord这个像素点的RGBA值
    gl_FragColor=texture2D(vTexture, aCoord);
}
