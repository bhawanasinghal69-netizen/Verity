package com.apex.engine.rendering;

import android.opengl.GLES20;

public class ShaderProgram {
    private int programId;
    private int vertexShaderId;
    private int fragmentShaderId;

    private static final String VERTEX_SHADER = 
        "uniform mat4 uMVPMatrix;\n" +
        "attribute vec4 vPosition;\n" +
        "attribute vec3 vNormal;\n" +
        "attribute vec2 vTexCoord;\n" +
        "varying vec3 fragNormal;\n" +
        "varying vec2 fragTexCoord;\n" +
        "void main() {\n" +
        "  gl_Position = uMVPMatrix * vPosition;\n" +
        "  fragNormal = vNormal;\n" +
        "  fragTexCoord = vTexCoord;\n" +
        "}\n";

    private static final String FRAGMENT_SHADER =
        "precision mediump float;\n" +
        "uniform sampler2D uTexture;\n" +
        "uniform vec3 uLightPos;\n" +
        "uniform vec3 uLightColor;\n" +
        "uniform float uAmbientStrength;\n" +
        "varying vec3 fragNormal;\n" +
        "varying vec2 fragTexCoord;\n" +
        "void main() {\n" +
        "  vec3 norm = normalize(fragNormal);\n" +
        "  vec3 lightDir = normalize(uLightPos);\n" +
        "  float diff = max(dot(norm, lightDir), 0.0);\n" +
        "  vec3 result = (uAmbientStrength + diff) * uLightColor;\n" +
        "  gl_FragColor = texture2D(uTexture, fragTexCoord) * vec4(result, 1.0);\n" +
        "}\n";

    public void compile() {
        vertexShaderId = compileShader(GLES20.GL_VERTEX_SHADER, VERTEX_SHADER);
        fragmentShaderId = compileShader(GLES20.GL_FRAGMENT_SHADER, FRAGMENT_SHADER);
        
        programId = GLES20.glCreateProgram();
        GLES20.glAttachShader(programId, vertexShaderId);
        GLES20.glAttachShader(programId, fragmentShaderId);
        GLES20.glLinkProgram(programId);
    }

    private int compileShader(int type, String source) {
        int shader = GLES20.glCreateShader(type);
        GLES20.glShaderSource(shader, source);
        GLES20.glCompileShader(shader);
        return shader;
    }

    public void use() {
        GLES20.glUseProgram(programId);
    }

    public int getProgramId() {
        return programId;
    }
}
