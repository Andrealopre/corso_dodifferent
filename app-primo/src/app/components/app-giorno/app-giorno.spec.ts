import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AppGiorno } from './app-giorno';

describe('AppGiorno', () => {
  let component: AppGiorno;
  let fixture: ComponentFixture<AppGiorno>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AppGiorno],
    }).compileComponents();

    fixture = TestBed.createComponent(AppGiorno);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
