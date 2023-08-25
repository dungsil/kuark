package kuark.collection.map

/**
 * A map that contains multiple values in a single value
 *
 * It is stored internally in the form [Map<K, List<V>>].
 *
 * @since 0.1.0
 */
public interface MultiValueMap<K, V> : MutableMap<K, MutableList<V>> {
  public fun getOne(key: K): V?

  public fun add(key: K, value: V)
}
