import { TestBed, async } from '@angular/core/testing';

import { AppComponent } from './app.component';

import { TodoComponent } from './todo/todo.component';

import { TodoDataService } from './todo-data.service';

describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
         TodoComponent
      ],
      providers: [TodoDataService]
    }).compileComponents();
  }));

  it('should create the app', async(() => {
    const fixture = TestBed.createComponent(TodoComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app).toBeTruthy();
  }));

});
