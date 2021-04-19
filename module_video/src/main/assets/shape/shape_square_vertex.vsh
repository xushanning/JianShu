//正方形 顶点着色器

//坐标
attribute vec4 vPosition;
uniform mat4 vMatrix;


void main(){
    gl_Postion=vMatrix*vPosition;
}