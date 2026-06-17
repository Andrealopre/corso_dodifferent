import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GeometriaApp } from './geometria-app';

describe('GeometriaApp', () => {
  let component: GeometriaApp;
  let fixture: ComponentFixture<GeometriaApp>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GeometriaApp],
    }).compileComponents();

    fixture = TestBed.createComponent(GeometriaApp);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
