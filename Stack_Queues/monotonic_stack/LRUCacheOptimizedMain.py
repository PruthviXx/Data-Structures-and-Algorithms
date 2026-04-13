class Node:
    def __init__(self, key, value):
        self.key = key
        self.value = value
        self.prev = None
        self.next = None


class LRUCache:
    def __init__(self, capacity: int):
        self.capacity = capacity
        self.map = {}

        self.head = Node(0, 0)
        self.tail = Node(0, 0)

        self.head.next = self.tail
        self.tail.prev = self.head

    def get(self, key: int) -> int:
        if key not in self.map:
            return -1

        node = self.map[key]
        self._update(node, node.value)
        return node.value

    def put(self, key: int, value: int) -> None:
        if key in self.map:
            self._update(self.map[key], value)
            return

        if len(self.map) >= self.capacity:
            self._remove_lru()

        self._insert_new(key, value)

    def _update(self, node, new_value):
        node.value = new_value

        # detach
        node.prev.next = node.next
        node.next.prev = node.prev

        # attach after head
        head_next = self.head.next
        self.head.next = node
        node.next = head_next
        node.prev = self.head
        head_next.prev = node

    def _insert_new(self, key, value):
        new_node = Node(key, value)

        head_next = self.head.next
        self.head.next = new_node
        new_node.next = head_next
        new_node.prev = self.head
        head_next.prev = new_node

        self.map[key] = new_node

    def _remove_lru(self):
        lru = self.tail.prev
        if lru == self.head:
            return

        lru.prev.next = self.tail
        self.tail.prev = lru.prev

        del self.map[lru.key]


# Test
lru = LRUCache(2)
lru.put(1, 4)
lru.put(2, 10)
print(lru.get(1))
lru.put(3, 8)
print(lru.get(2))
lru.put(4, 2)
print(lru.get(1))
print(lru.get(3))
print(lru.get(4))