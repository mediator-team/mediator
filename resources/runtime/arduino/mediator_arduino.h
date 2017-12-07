#ifndef _MEDIATOR_ARDUINO_H_
#define _MEDIATOR_ARDUINO_H_

struct __MR_List {
    void * list;
    int capacity;
    int num_items;
    int item_size;
}

typedef struct __MR_List MR_List;

void init_empty_list(MR_List list, int item_size);
void list_add(MR_List, void * );
void * list_get(MR_List list, int index);
void list_del(MR_List list, int index);

struct __MR_Map {
    MR_List keys;
    MR_List values;
};
typedef struct __MR_Map MR_Map;

void init_empty_map(MR_Map map, int key_size, int value_size);
void * map_put(MR_Map map, void * key, void * value);
void map_get(MR_Map map, void * key);
void map_del(MR_Map map, void * key);

#endif