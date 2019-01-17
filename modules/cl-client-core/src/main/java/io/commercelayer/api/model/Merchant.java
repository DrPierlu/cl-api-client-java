package io.commercelayer.api.model;

import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import moe.banana.jsonapi2.HasOne;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "merchants"
)
public class Merchant extends ApiResource {
  public static final long serialVersionUID = -1;

  public static final List<Class<? extends ApiResource>> _RELATED_RESOURCES = Collections.unmodifiableList(Arrays.asList(Address.class));

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
    return (Address)getResource(getAddress().get(getDocument()));
  }

  public void setAddressResource(Address address) {
    setAddress(new HasOne<Address>(address));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getAddressLinksMap() {
    return (Map<String, String>)getAddress().getLinks().get(new CLLinksAdapter());
  }
}
