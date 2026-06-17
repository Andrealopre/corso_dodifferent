import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Stile } from './stile';

describe('Stile', () => {
  let component: Stile;
  let fixture: ComponentFixture<Stile>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Stile],
    }).compileComponents();

    fixture = TestBed.createComponent(Stile);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
