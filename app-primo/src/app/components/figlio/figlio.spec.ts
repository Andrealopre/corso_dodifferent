import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Figlio } from './figlio';

describe('Figlio', () => {
  let component: Figlio;
  let fixture: ComponentFixture<Figlio>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Figlio],
    }).compileComponents();

    fixture = TestBed.createComponent(Figlio);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
