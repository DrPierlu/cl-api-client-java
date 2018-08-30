package io.commercelayer.api.model;

import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Map;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "merchants"
)
public class Merchant extends ApiResource {
  public static final long serialVersionUID = -1;

  private String name;

  private HasOne<Address> address;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HasOne<Address> getAddress() {
    return this.address;
  }

  public void setAddress(HasOne<Address> address) {
    this.address = address;
  }

  public Address getAddressResource() {
    return getAddress().get(getDocument());
  }

  public void setAddressResource(Address address) {
    setAddress(new HasOne<Address>(address));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getAddressLinksMap() {
    return (Map<String, String>)getAddress().getLinks().get(new CLLinksAdapter());
  }
}
