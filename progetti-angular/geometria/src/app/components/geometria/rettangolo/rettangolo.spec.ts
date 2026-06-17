import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Rettangolo } from './rettangolo';

describe('Rettangolo', () => {
  let component: Rettangolo;
  let fixture: ComponentFixture<Rettangolo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Rettangolo],
    }).compileComponents();

    fixture = TestBed.createComponent(Rettangolo);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
