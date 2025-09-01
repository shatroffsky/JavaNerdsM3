package com.codegym.model;

public class RestResponse {
  private  String userId;
  private  String id;
  private  String title;
  private  String body;

  public RestResponse() {
  }

  public RestResponse(String userId, String id, String title, String body) {
    this.userId = userId;
    this.id = id;
    this.title = title;
    this.body = body;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("RestResponse{");
    sb.append("userId='").append(userId).append('\'');
    sb.append(", id='").append(id).append('\'');
    sb.append(", title='").append(title).append('\'');
    sb.append(", body='").append(body).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
