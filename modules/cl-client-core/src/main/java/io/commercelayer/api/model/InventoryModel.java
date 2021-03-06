package io.commercelayer.api.model;

import com.squareup.moshi.Json;
import io.commercelayer.api.model.adapter.CLLinksAdapter;
import io.commercelayer.api.model.common.ApiResource;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import moe.banana.jsonapi2.HasMany;
import moe.banana.jsonapi2.JsonApi;

@JsonApi(
    type = "inventory_models"
)
public class InventoryModel extends ApiResource {
  public static final long serialVersionUID = -1;

  public static final List<Class<? extends ApiResource>> _RELATED_RESOURCES = Collections.unmodifiableList(Arrays.asList(StockLevel.class));

  private String name;

  @Json(
      name = "stock_levels"
  )
  private HasMany<StockLevel> stockLevels;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public HasMany<StockLevel> getStockLevels() {
    return this.stockLevels;
  }

  public void setStockLevels(HasMany<StockLevel> stockLevels) {
    this.stockLevels = stockLevels;
  }

  @SuppressWarnings("unchecked")
  public List<StockLevel> getStockLevelResourceList() {
    return (List<StockLevel>)getResource(getStockLevels().get(getDocument()));
  }

  public void setStockLevelResourceList(List<StockLevel> stockLevels) {
    setStockLevels(new HasMany<StockLevel>(stockLevels.toArray(new StockLevel[0])));
  }

  @SuppressWarnings("unchecked")
  public Map<String, String> getStockLevelsLinksMap() {
    return (Map<String, String>)getStockLevels().getLinks().get(new CLLinksAdapter());
  }

  public interface Inclusions {
    String STOCK_LEVELS = "stock_levels";
  }
}
