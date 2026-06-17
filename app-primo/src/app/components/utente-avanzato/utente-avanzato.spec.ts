import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UtenteAvanzato } from './utente-avanzato';

describe('UtenteAvanzato', () => {
  let component: UtenteAvanzato;
  let fixture: ComponentFixture<UtenteAvanzato>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UtenteAvanzato],
    }).compileComponents();

    fixture = TestBed.createComponent(UtenteAvanzato);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
