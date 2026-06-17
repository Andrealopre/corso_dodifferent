import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Quadrato } from './quadrato';

describe('Quadrato', () => {
  let component: Quadrato;
  let fixture: ComponentFixture<Quadrato>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Quadrato],
    }).compileComponents();

    fixture = TestBed.createComponent(Quadrato);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
