//正方形 片元着色器

precision mediump float;
uniform vec4 vColor;

void main(){
    gl_FragColor=vColor;
}