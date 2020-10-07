package com.example.foro.entities;

public class Comentarios {
    private int idComment;
    private int idForo;
    private String comentario;
    private String userCreador;

    public Comentarios(){

    }

    public Comentarios(int idComment, int idForo, String comentario, String userCreador) {
        this.idComment = idComment;
        this.idForo = idForo;
        this.comentario = comentario;
        this.userCreador = userCreador;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public int getIdForo() {
        return idForo;
    }

    public void setIdForo(int idForo) {
        this.idForo = idForo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getUserCreador() {
        return userCreador;
    }

    public void setUserCreador(String userCreador) {
        this.userCreador = userCreador;
    }
}
