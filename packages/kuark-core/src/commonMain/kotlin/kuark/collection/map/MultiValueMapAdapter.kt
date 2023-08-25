package kuark.collection.map

/**
 * An adapter that declares and manages a generic Map internally.
 *
 * Most calls will pass the internally declared map as is.
 *
 * @property map the map to be used internally
 * @param K the type of the keys in the map
 * @param V the type of the values in the map
 * @since 0.1.0
 */
public abstract class MultiValueMapAdapter<K, V>(
  protected val map: MutableMap<K, MutableList<V>>,
) : MultiValueMap<K, V> {

  override fun getOne(key: K): V? = this.map[key]?.firstOrNull()

  override fun add(key: K, value: V) {
    this.map.computeIfAbsent(key) { mutableListOf() }
    this.map[key]!!.add(value)
  }

  // //=========================================================================

  override val keys: MutableSet<K>
    get() = this.map.keys
  override val values: MutableCollection<MutableList<V>>
    get() = this.map.values.toMutableList()
  override val size: Int
    get() = this.map.size
  override val entries: MutableSet<MutableMap.MutableEntry<K, MutableList<V>>>
    get() = this.map.entries

  override fun isEmpty(): Boolean = this.map.isEmpty()
  override fun containsKey(key: K): Boolean = this.map.containsKey(key)
  override fun containsValue(value: MutableList<V>): Boolean = this.map.containsValue(value)

  override fun get(key: K): MutableList<V>? = this.map[key]

  override fun put(key: K, value: MutableList<V>): MutableList<V>? = this.map.put(key, value)
  override fun putAll(from: Map<out K, MutableList<V>>): Unit = this.map.putAll(from)

  override fun remove(key: K): MutableList<V>? = this.map.remove(key)
  override fun clear(): Unit = this.map.clear()
}
