#include "mediator_arduino.h"


short __memory_allocation_initialized = 0;

/***********************************************************************************
* LIST
* - a dynamic array of any Mediator types
***********************************************************************************/


struct __MR_List {
    MR_List_Node * root;
};

struct __MR_List_Node {
    void * data;
    MR_List_Node * next;
};

/***********************************************************************************
* Map
* - a dynamic dictionary that maps a term to another term
***********************************************************************************/

struct __MR_Map {
    MR_Map_Node * root;
};

struct __MR_Map_Node {
    void * key;
    void * value;
    MR_List_Node * next;
};