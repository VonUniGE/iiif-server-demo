package de.digitalcollections.iiif.serverdemo.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
public class DemoControllerTest {

  private MockMvc mvc;

  @Before
  public void setUp() throws Exception {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/view/");
    mvc = MockMvcBuilders.standaloneSetup(new DemoController())
            .setViewResolvers(resolver)
            .build();
  }

  @Test
  public void getHello() throws Exception {
    ResultActions perform = mvc.perform(MockMvcRequestBuilders.get("/1234/view_image.html").accept(MediaType.TEXT_HTML));
    perform.andExpect(MockMvcResultMatchers.status().isOk());
  }

  @Test
  public void shouldGetHomepage() throws Exception {
    mvc.perform(get("/"))
            .andExpect(model().attribute("active", is("home")));
  }

  @Test
  public void shouldGetAbout() throws Exception {
    mvc.perform(get("/about"))
            .andExpect(model().attribute("active", is("about")));
  }

  @Test
  public void shouldGetImageRequestUrlDemo() throws Exception {
    mvc.perform(get("/image-request-url.html"))
            .andExpect(model().attribute("active", is("demos")));
  }

  @Test
  public void shouldGetImageInfoUrlDemo() throws Exception {
    mvc.perform(get("/image-info-url.html"))
            .andExpect(model().attribute("active", is("demos")));
  }

  @Test
  public void shouldGetOpenSeadragonPage() throws Exception {
    mvc.perform(get("/12345/view_image.html"))
            .andExpect(model().attribute("active", is("demos")))
            .andExpect(model().attribute("infoUrl", is("/image/v2/12345/info.json")));
  }

  @Test
  public void shouldGetLeafletImageViewerPage() throws Exception {
    mvc.perform(get("/12345/view_leaflet-image.html"))
            .andExpect(model().attribute("active", is("demos")))
            .andExpect(model().attribute("infoUrl", is("/image/v2/12345/info.json")));
  }

  @Test
  public void shouldGetPresentationManifestDemo() throws Exception {
    mvc.perform(get("/12345/presentation-manifest-url.html"))
            .andExpect(model().attribute("active", is("demos")))
            .andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }

  @Test
  public void shouldGetCollectionManifestDemo() throws Exception {
    mvc.perform(get("/12345/presentation-collection-url.html"))
            .andExpect(model().attribute("active", is("demos")))
            .andExpect(model().attribute("manifestId", is("/presentation/v2/collection/12345")));
  }

  @Test
  public void shouldGetMiradorPage() throws Exception {
    mvc.perform(get("/12345/view_mirador.html"))
            .andExpect(model().attribute("active", is("demos")))
            .andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }

  @Test
  public void shouldGetMiradorCanvasLinkPage() throws Exception {
    mvc.perform(get("/12345/view_mirador_canvaslink.html"))
            .andExpect(model().attribute("active", is("demos")))
            .andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }

  @Test
  public void shouldGetMiradorImageCropperPage() throws Exception {
    mvc.perform(get("/12345/view_mirador_imagecropper.html"))
            .andExpect(model().attribute("active", is("demos")))
            .andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }

  @Test
  public void shouldGetMiradorKeyboardNavigationPage() throws Exception {
    mvc.perform(get("/12345/view_mirador_keyboardnavigation.html"))
            .andExpect(model().attribute("active", is("demos")))
            .andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }

  @Test
  public void shouldGetMiradorManifestButtonPage() throws Exception {
    mvc.perform(get("/12345/view_mirador_manifestbutton.html"))
            .andExpect(model().attribute("active", is("demos")))
            .andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }

  @Test
  public void shouldGetMiradorMultiPageNavigationPage() throws Exception {
    mvc.perform(get("/12345/view_mirador_multipagenavigation.html"))
            .andExpect(model().attribute("active", is("demos")))
            .andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }

  @Test
  public void shouldGetMiradorPyhsicalRulerPage() throws Exception {
    mvc.perform(get("/12345/view_mirador_physicalruler.html"))
            .andExpect(model().attribute("active", is("demos")))
            .andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }

  @Test
  public void shouldGetMiradorViewFromUrlPage() throws Exception {
    mvc.perform(get("/12345/view_mirador_viewfromurl.html"))
            .andExpect(model().attribute("active", is("demos")))
            .andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }

  @Test
  public void shouldGetUniversalViewerPage() throws Exception {
    mvc.perform(get("/12345/view_universal.html"))
            .andExpect(model().attribute("active", is("demos")))
            .andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }

  @Test
  public void shouldGetLeafletManifestViewerPage() throws Exception {
    mvc.perform(get("/12345/view_leaflet-presentation.html"))
            .andExpect(model().attribute("active", is("demos")))
            .andExpect(model().attribute("manifestId", is("/presentation/v2/12345/manifest")));
  }
}
