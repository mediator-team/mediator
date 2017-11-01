#ifndef _MEDIATOR_ARDUINO_H_
#define _MEDIATOR_ARDUINO_H_

struct __MR_List;
typedef struct __MR_List MR_List;

struct __MR_List_Node;
typedef struct __MR_List_Node MR_List_Node;

MR_List * create_empty_list();
MR_List * list_append(MR_List *, void * );

struct __MR_Map;
typedef struct __MR_Map MR_Map;

struct __MR_Map_Node;

#endif