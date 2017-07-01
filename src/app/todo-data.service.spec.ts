import { TestBed, inject } from '@angular/core/testing';

import { Todo } from './todo/todo';
import { TodoDataService } from './todo-data.service';

describe('TodoDataServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TodoDataService]
    });
  });

  it('should be created', inject([TodoDataService], (service: TodoDataService) => {
    expect(service).toBeTruthy();
  }));

  describe('addTodo', () => {

    it('should initialise with an empty todo array', inject([TodoDataService], (service: TodoDataService) => {
      expect(service.getAllTodos()).toEqual([]);
    }));

    it('should add a valid todo', inject([TodoDataService], (service: TodoDataService) => {
      const todo1 = new Todo({ title: 'learn angular 2', complete: false });
      service.addTodo(todo1);
      expect(service.todos[0]).toEqual(todo1);
    }));


  });

  describe('getAllTodos', () => {

    it('should initialise with an empty todo array', inject([TodoDataService], (service: TodoDataService) => {
      expect(service.getAllTodos()).toEqual([]);
    }));

    it('should return all todos', inject([TodoDataService], (service: TodoDataService) => {
      const todo1 = new Todo({ id:1, title: 'learn angular 2', completed: false });
      const todo2 = new Todo({id: 2, title: '???', completed: false });
      const todo3 = new Todo({id: 3, title: 'profit', completed: true });
      service.addTodo(todo1);
      service.addTodo(todo2);
      service.addTodo(todo3);
      debugger;
      expect(service.getAllTodos()).toEqual([todo3, todo2, todo1]);
    }));


  });

  describe('toggle todos', () => {

    it('should initialise with an empty todo array', inject([TodoDataService], (service: TodoDataService) => {
      expect(service.getAllTodos()).toEqual([]);
    }));

    it('should mark incomplete todos as complete', inject([TodoDataService], (service: TodoDataService) => {
      const incomplete = new Todo({ id: 123, title: 'learn angular 2', completed: false });
      service.addTodo(incomplete);

      let temp = service.getTodoById(123);
      service.toggleComplete(temp.id);
      expect(service.getTodoById(123).completed).toEqual(true);
    }));

    it('should mark completed todos as incomplete', inject([TodoDataService], (service: TodoDataService) => {
      const incomplete = new Todo({ id: 123, title: 'learn angular 2', completed: true });
      service.addTodo(incomplete);

      let temp = service.getTodoById(123);
      service.toggleComplete(temp.id);
      expect(service.getTodoById(123).completed).toEqual(false);
    }));
  });

  describe('delete todo', () => {

    it('should initialise with an empty todo array', inject([TodoDataService], (service: TodoDataService) => {
      expect(service.getAllTodos()).toEqual([]);
    }));

    it('should delete the requested todo', inject([TodoDataService], (service: TodoDataService) => {
      const todo1 = new Todo({ title: 'learn angular 2', complete: false });
      const todo2 = new Todo({ id: 123, title: '???', complete: false });
      service.addTodo(todo1);
      service.addTodo(todo2);
      service.deleteTodo(123);

      expect(service.getAllTodos()).toEqual([todo1]);
    }));


  });


});
