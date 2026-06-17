import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Cerchio } from './cerchio';

describe('Cerchio', () => {
  let component: Cerchio;
  let fixture: ComponentFixture<Cerchio>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [Cerchio],
    }).compileComponents();

    fixture = TestBed.createComponent(Cerchio);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
