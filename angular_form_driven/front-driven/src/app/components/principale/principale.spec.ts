import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Principale } from './principale';

describe('Principale', () => {
  let component: Principale;
  let fixture: ComponentFixture<Principale>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Principale],
    }).compileComponents();

    fixture = TestBed.createComponent(Principale);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
