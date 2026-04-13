#include <iostream>
#include <unordered_map>
using namespace std;

class LRUCache {
private:
    struct Node {
        int key, value;
        Node* prev;
        Node* next;
        Node(int k, int v) : key(k), value(v), prev(nullptr), next(nullptr) {}
    };

    int capacity;
    unordered_map<int, Node*> mp;
    Node* head;
    Node* tail;

    void update(Node* node, int newValue) {
        node->value = newValue;

        // detach
        node->prev->next = node->next;
        node->next->prev = node->prev;

        // attach after head
        Node* headNext = head->next;
        head->next = node;
        node->next = headNext;
        node->prev = head;
        headNext->prev = node;
    }

    void insertNew(int key, int value) {
        Node* newNode = new Node(key, value);

        Node* headNext = head->next;
        head->next = newNode;
        newNode->next = headNext;
        newNode->prev = head;
        headNext->prev = newNode;

        mp[key] = newNode;
    }

    void removeLRU() {
        Node* lru = tail->prev;
        if (lru == head) return;

        lru->prev->next = tail;
        tail->prev = lru->prev;

        mp.erase(lru->key);
        delete lru;
    }

public:
    LRUCache(int cap) {
        capacity = cap;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head->next = tail;
        tail->prev = head;
    }

    int get(int key) {
        if (mp.find(key) == mp.end())
            return -1;

        Node* node = mp[key];
        update(node, node->value);
        return node->value;
    }

    void put(int key, int value) {
        if (mp.find(key) != mp.end()) {
            update(mp[key], value);
            return;
        }

        if (mp.size() >= capacity)
            removeLRU();

        insertNew(key, value);
    }
};

int main() {
    LRUCache lru(2);

    lru.put(1, 4);
    lru.put(2, 10);
    cout << lru.get(1) << endl;
    lru.put(3, 8);
    cout << lru.get(2) << endl;
    lru.put(4, 2);
    cout << lru.get(1) << endl;
    cout << lru.get(3) << endl;
    cout << lru.get(4) << endl;

    return 0;
}