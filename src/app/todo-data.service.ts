import { Injectable } from '@angular/core';

import { Todo } from './todo/todo';

@Injectable()
export class TodoDataService {

  id: number = 0; //service will generate todo ids
  todos: Todo[] = new Array<Todo>();

  constructor() { }

// queries
  getAllTodos(): Todo[] {
    return this.todos;
  }

// actions
  addTodo(todo: Todo): void {
    if(!todo.id){ todo.id = this.id++; }

    this.todos.splice(0,0,todo); //ensures new items are at the "top" of the list
  }

  toggleComplete(id: number): void {
    this.todos.filter(todo => todo.id === id).map(todo => todo.completed = !todo.completed);
  }

  deleteTodo(id: number): void {
    this.todos = this.todos.filter(todo => todo.id !== id);
  }

}
