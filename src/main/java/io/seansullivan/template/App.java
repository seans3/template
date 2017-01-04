package io.seansullivan.template;


import com.google.common.base.Objects;
import com.google.common.base.Preconditions;


/**
 * Template "Hello World!" application. 
 *
 * @author Sean Sullivan (sean@seansullivan.io)
 */
public class App {

  private int field1;
  private String field2;

  /**
   * @param field1 integer ...
   * @param field2 String ...
   */
  public App(int field1, String field2) {
    this.field1 = field1;
    this.field2 = field2;
  }

  public int getField1() {
    return field1;
  }

  public void setField1(int field1) {
    this.field1 = field1;
  }

  public String getField2() {
    return field2;
  }

  public void setField2(String field2) {
    Preconditions.checkNotNull(field2);
    Preconditions.checkArgument(field2.length() > 0);

    this.field2 = field2;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    } else if (!(o instanceof App)) {
      return false;
    }
    App other = (App) o;
    // Compare all fields
    boolean isEquals = true;
    if (this.field1 != other.field1) {
      isEquals = false;
    }
    if (!this.field2.equals(other.field2)) {
      isEquals = false;
    }
    return isEquals;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(this.field1, this.field2);
  }
  
  @Override
  public String toString() {
    StringBuilder buffer = new StringBuilder();
    buffer.append("App:\n");
    buffer.append("  Field 1: ").append(field1).append("\n");
    buffer.append("  Field 2: ").append(field2).append("\n");
    return buffer.toString();
  }
  
  public static void main(String[] args) {
    System.out.println("Starting...");
    App app = new App(1, "Test");
    System.out.print(app);
    System.out.println("Finished");
  }
}
