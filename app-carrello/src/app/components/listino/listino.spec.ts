import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Listino } from './listino';

describe('Listino', () => {
  let component: Listino;
  let fixture: ComponentFixture<Listino>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Listino],
    }).compileComponents();

    fixture = TestBed.createComponent(Listino);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
