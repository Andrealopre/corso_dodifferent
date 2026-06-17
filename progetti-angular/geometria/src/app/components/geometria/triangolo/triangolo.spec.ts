import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Triangolo } from './triangolo';

describe('Triangolo', () => {
  let component: Triangolo;
  let fixture: ComponentFixture<Triangolo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Triangolo],
    }).compileComponents();

    fixture = TestBed.createComponent(Triangolo);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
