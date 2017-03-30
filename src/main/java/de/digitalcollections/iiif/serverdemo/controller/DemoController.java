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
    model.addAttribute("active", "home");
    return "index";
  }

  @RequestMapping(value = {"/about"}, method = RequestMethod.GET)
  public String getAbout(Model model) {
    model.addAttribute("active", "about");
    return "about";
  }

  @RequestMapping(value = {"/image-request-url.html"}, method = RequestMethod.GET)
  public String getImageRequestUrlDemo(Model model) {
    model.addAttribute("active", "demos");
    return "view_image-request-url";
  }

  @RequestMapping(value = {"/image-info-url.html"}, method = RequestMethod.GET)
  public String getImageInfoUrlDemo(Model model) {
    model.addAttribute("active", "demos");
    return "view_image-info-url";
  }

  @RequestMapping(value = "/{identifier}/view_image.html", method = RequestMethod.GET)
  public String getPreviewPage(@PathVariable String identifier,
          HttpServletRequest request, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("infoUrl", "/image/v2/" + identifier + "/info.json");
    return "view_openseadragon";
  }

  @RequestMapping(value = "/{identifier}/view_iipmoo.html", method = RequestMethod.GET)
  public String getIIPMooViewerPage(@PathVariable String identifier,
          HttpServletRequest request, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("serverUrl", "/iiif/image/2.0.0/");
    model.addAttribute("image", identifier);
    return "view_iipmoo";
  }

  @RequestMapping(value = "/{identifier}/view_leaflet-image.html", method = RequestMethod.GET)
  public String getLeafletImageViewerPage(@PathVariable String identifier,
          HttpServletRequest request, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("infoUrl", "/image/v2/" + identifier + "/info.json");
    return "view_leaflet-image";
  }

  @RequestMapping(value = "/{identifier}/view_leaflet-presentation.html", method = RequestMethod.GET)
  public String getLeafletManifestViewerPage(@PathVariable String identifier,
          HttpServletRequest request, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "view_leaflet-presentation";
  }

  @RequestMapping(value = {"/presentation-api-url.html"}, method = RequestMethod.GET)
  public String getPresentationApiUrlDemo(Model model) {
    model.addAttribute("active", "demos");
    return "view_presenation-api-url";
  }

  @RequestMapping(value = "/{identifier}/view_presentation.html", method = RequestMethod.GET)
  public String getMiradorPage(@PathVariable String identifier,
          HttpServletRequest request, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "view_mirador";
  }

  @RequestMapping(value = "/{identifier}/view_universal.html", method = RequestMethod.GET)
  public String getUniversalViewerPage(@PathVariable String identifier,
          HttpServletRequest request, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "view_universal";
  }
}