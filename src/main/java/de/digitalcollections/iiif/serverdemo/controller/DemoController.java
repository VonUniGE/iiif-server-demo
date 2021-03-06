package de.digitalcollections.iiif.serverdemo.controller;

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
  public String getOpenSeadragonPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("infoUrl", "/image/v2/" + identifier + "/info.json");
    return "view_openseadragon";
  }

  @RequestMapping(value = "/{identifier}/view_leaflet-image.html", method = RequestMethod.GET)
  public String getLeafletImageViewerPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("infoUrl", "/image/v2/" + identifier + "/info.json");
    return "view_leaflet-image";
  }

  @RequestMapping(value = "/{identifier}/view_leaflet-presentation.html", method = RequestMethod.GET)
  public String getLeafletManifestViewerPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "view_leaflet-presentation";
  }

  @RequestMapping(value = {"/{identifier}/presentation-manifest-url.html"},
          method = RequestMethod.GET)
  public String getPresentationManifestUrlDemo(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "view_presentation-manifest-url";
  }

  @RequestMapping(value = {"/{name}/presentation-collection-url.html"},
          method = RequestMethod.GET)
  public String getPresentationCollectionUrlDemo(@PathVariable String name, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/collection/" + name);
    return "view_presentation-collection-url";
  }

  @RequestMapping(value = "/{identifier}/view_mirador.html", method = RequestMethod.GET)
  public String getMiradorPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "view_mirador";
  }

  @RequestMapping(value = "/{identifier}/view_universal.html", method = RequestMethod.GET)
  public String getUniversalViewerPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "view_universal";
  }

  @RequestMapping(value = "/{identifier}/view_mirador_canvaslink.html", method = RequestMethod.GET)
  public String getMiradorCanvasLinkPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "view_mirador_canvaslink";
  }

  @RequestMapping(value = "/{identifier}/view_mirador_imagecropper.html", method = RequestMethod.GET)
  public String getMiradorImageCropperPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "view_mirador_imagecropper";
  }

  @RequestMapping(value = "/{identifier}/view_mirador_keyboardnavigation.html", method = RequestMethod.GET)
  public String getMiradorKeyboardNavigationPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "view_mirador_keyboardnavigation";
  }

  @RequestMapping(value = "/{identifier}/view_mirador_manifestbutton.html", method = RequestMethod.GET)
  public String getMiradorManifestButtonPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "view_mirador_manifestbutton";
  }

  @RequestMapping(value = "/{identifier}/view_mirador_multipagenavigation.html", method = RequestMethod.GET)
  public String getMiradorMultiPageNavigationPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "view_mirador_multipagenavigation";
  }

  @RequestMapping(value = "/{identifier}/view_mirador_viewfromurl.html", method = RequestMethod.GET)
  public String getMiradorViewFromUrlPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "view_mirador_viewfromurl";
  }

  @RequestMapping(value = "/{identifier}/view_mirador_physicalruler.html", method = RequestMethod.GET)
  public String getMiradorPhysicalRulerPage(@PathVariable String identifier, Model model) {
    model.addAttribute("active", "demos");
    model.addAttribute("manifestId", "/presentation/v2/" + identifier + "/manifest");
    return "view_mirador_physicalruler";
  }
}
