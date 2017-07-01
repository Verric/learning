import { Component } from '@angular/core';
import { TodoDataService } from '../todo-data.service';
import { Todo } from './todo';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent  {

  constructor(private service: TodoDataService){ }

  get todos() {
    return this.service.getAllTodos();
  }

  get completedItems(): number {
    return this.todos.filter(todo => todo.completed).length;
  }

  addTodo(input: HTMLInputElement) {
    
    this.service.addTodo({
      id: undefined,
      title: input.value,
      completed: false
    });
    input.value = '';
  }

  deleteTodo(todo:Todo):void {
    this.service.deleteTodo(todo.id);
  }

  toggleComplete(todo:Todo) {
    this.service.toggleComplete(todo.id);
  }
}
