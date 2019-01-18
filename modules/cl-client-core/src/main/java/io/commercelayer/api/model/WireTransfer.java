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
    type = "wire_transfers"
)
public class WireTransfer extends ApiResource {
  public static final long serialVersionUID = -1;

  public static final List<Class<? extends ApiResource>> _RELATED_RESOURCES = Collections.unmodifiableList(Arrays.asList(Order.class));

  private HasOne<Order> order;

  public HasOne<Order> getOrder() {
    return this.order;
  }

  public void setOrder(HasOne<Order> order) {
    this.order = order;
  }

  public Order getOrderResource() {
    return (Order)getResource(getOrder().get(getDocument()));
  }

  public void setOrderResource(Order order) {
    setOrder(new HasOne<Order>(order));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getOrderLinksMap() {
    return (Map<String, String>)getOrder().getLinks().get(new CLLinksAdapter());
  }

  public interface Inclusions {
    String ORDER = "order";
  }
}
