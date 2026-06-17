import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FiglioUno } from './figlio-uno';

describe('FiglioUno', () => {
  let component: FiglioUno;
  let fixture: ComponentFixture<FiglioUno>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FiglioUno],
    }).compileComponents();

    fixture = TestBed.createComponent(FiglioUno);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
