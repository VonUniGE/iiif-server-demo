package de.digitalcollections.iiif.serverdemo.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Demo controller for serving IIIF services on demo data.
 */
@Controller
public class DemoController {

  @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
  public String getHomepage(Model model) {
    return "index";
  }

  @RequestMapping(value = {"/about"}, method = RequestMethod.GET)
  public String getAbout(Model model) {
    return "about";
  }

  @RequestMapping(value = {"/demo/image-api-url.html"}, method = RequestMethod.GET)
  public String getImageApiUrlDemo(Model model) {
    return "view_image-api-url";
  }

  @RequestMapping(value = "/demo/{identifier}/view_image.html", method = RequestMethod.GET)
  public String getPreviewPage(@PathVariable String identifier,
          HttpServletRequest request, Model model) {
    model.addAttribute("infoUrl", "/iiif/image/" + identifier + "/info.json");
    return "view_openseadragon";
  }

  @RequestMapping(value = "/demo/{identifier}/view_presentation.html", method = RequestMethod.GET)
  public String getMiradorPage(@PathVariable String identifier,
          HttpServletRequest request, Model model) {
    model.addAttribute("manifestId", "/iiif/presentation/" + identifier + "/manifest.json");
    return "view_mirador";
  }

}
