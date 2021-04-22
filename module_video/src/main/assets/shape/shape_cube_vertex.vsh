//正方体顶点着色器

attribute vec4 vPosition;
uniform mat4 vMatrix;
attribute vec4 vColor;
varying vec4 aColor;

void main(){
    gl_Position=vMatrix*vPosition;
    aColor=vColor;
}