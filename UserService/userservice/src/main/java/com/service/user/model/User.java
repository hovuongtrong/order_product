package com.service.user.model;

import java.util.Objects;
import lombok.Data;
import javax.annotation.Generated;

/**
 * User
 */

@Data
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-10T10:41:55.316283+07:00[Asia/Ho_Chi_Minh]")
public class User {

  private String username;

  private String password;

  private String status;

  private String name;

  private String fullname;

  private Long phonenumber;

  private String address;

  private String role;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.username, user.username) &&
        Objects.equals(this.password, user.password) &&
        Objects.equals(this.status, user.status) &&
        Objects.equals(this.name, user.name) &&
        Objects.equals(this.fullname, user.fullname) &&
        Objects.equals(this.phonenumber, user.phonenumber) &&
        Objects.equals(this.address, user.address) &&
        Objects.equals(this.role, user.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password, status, name, fullname, phonenumber, address, role);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    fullname: ").append(toIndentedString(fullname)).append("\n");
    sb.append("    phonenumber: ").append(toIndentedString(phonenumber)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    role: ").append(toIndentedString(role)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

