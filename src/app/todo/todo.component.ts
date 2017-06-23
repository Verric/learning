import { Component } from '@angular/core';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent  {
  idCounter:number;
  todoCount:number;
  todos: Todo[];

  constructor() { 
    this.idCounter = 0;
    this.todoCount = 0;
    this.todos = new Array<Todo>();
  }

  addTodo(input:HTMLInputElement): void {
    let temp: Todo = {
      id: this.idCounter++,
      text: input.value
    };
    this.todos.push(temp);
    this.todoCount++;
    input.value = "";
  }

  completeTodo(id:number): void {
    this.todos = this.todos.filter(todo => todo.id !== id);
    this.todoCount--;
  }

}

class Todo {
  id: number;
  text: string;
}
