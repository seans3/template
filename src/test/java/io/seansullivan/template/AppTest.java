package io.seansullivan.template;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


/**
 * Unit test for simple App.
 */
@RunWith(JUnit4.class)
public class AppTest {

  private static final int FIELD_1 = 42;
  private static final String FIELD_2 = "This is a test";

  @Rule public final ExpectedException thrown = ExpectedException.none();
  @Mock private App mockApp;
    
  private App testApp;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    when(mockApp.getField1()).thenReturn(FIELD_1);
    testApp = new App(FIELD_1, FIELD_2);
  }

  @Test
  public void constructorTest() {
    assertThat(testApp.getField1()).isEqualTo(FIELD_1);
    assertThat(testApp.getField2()).isEqualTo(FIELD_2);
  }

  @Test
  public void getterSetterTest() {
    thrown.expect(NullPointerException.class);
    testApp.setField2(null);
    thrown.expect(IllegalArgumentException.class);
    testApp.setField2("");
  }
  
  @Test
  public void equalsTest() {
    assertThat(testApp).isNotEqualTo(null);
    assertThat(testApp).isNotEqualTo(new String("Hello"));
    App anotherApp = new App(FIELD_1, FIELD_2);
    assertThat(testApp).isEqualTo(anotherApp);
  }

  @Test
  public void hashCodeTest() {
    App anotherApp = new App(FIELD_1, "Different");
    assertThat(testApp.hashCode()).isNotEqualTo(anotherApp.hashCode());
    anotherApp = new App(24, FIELD_2);
    assertThat(testApp.hashCode()).isNotEqualTo(anotherApp.hashCode());
    anotherApp = new App(FIELD_1, FIELD_2);
    assertThat(testApp.hashCode()).isEqualTo(anotherApp.hashCode());
  }

  @Test
  public void booleanTest() {
    assertThat(true).isTrue();
    assertThat(false).isFalse();
  }
  
  @Test
  public void listTest() {
    assertThat(Arrays.asList(1, 2, 3)).contains(2);
    assertThat(Arrays.asList(1, 2, 3)).containsExactly(1, 2, 3).inOrder();
    assertThat(Arrays.asList(1, 2, 3)).containsAllOf(2, 3);
    assertThat(Arrays.asList(1, 2, 3)).containsAnyOf(1, 7);
  }
}
